package com.gmail.deamon999.scheduler.controllers;

import com.gmail.deamon999.scheduler.Const;
import com.gmail.deamon999.scheduler.entity.SchedulerJobInfo;
import com.gmail.deamon999.scheduler.jobs.EmailJob;
import com.gmail.deamon999.scheduler.payload.ScheduleEmailRequest;
import com.gmail.deamon999.scheduler.payload.ScheduleEmailResponse;
import com.gmail.deamon999.scheduler.repository.SchedulerJopRepo;
import com.gmail.deamon999.scheduler.service.EvaluateService;
import com.gmail.deamon999.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class JobController {

    @Autowired
    private SchedulerService schedulerService;
    @Autowired
    private SchedulerJopRepo schedulerJopRepo;
    @Autowired
    private EvaluateService evaluateService;

    @PostMapping("/ScheduleStartProject")
    public ResponseEntity<ScheduleEmailResponse> scheduleEmail(@Valid @RequestBody ScheduleEmailRequest scheduleEmailRequest) {
        String startTime = scheduleEmailRequest.getStartTime();
        String endTime = scheduleEmailRequest.getEndTime();

        try {
            ZonedDateTime start = ZonedDateTime.parse(startTime).withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime end = ZonedDateTime.parse(endTime).withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime utcDate = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC);

            if (start.isBefore(utcDate) && end.isBefore(utcDate)) {
                ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(false,
                        "Start and End time must be after current time");
                return new ResponseEntity<>(scheduleEmailResponse, HttpStatus.BAD_REQUEST);
            } else {

                SchedulerJobInfo startProject = schedulerJopRepo.findFirstByProjectIdAndJobGroupAndState(scheduleEmailRequest.getProjectId(), Const.PROJECT_START,
                        Const.JOB_ACTIVE);
                SchedulerJobInfo endProject = schedulerJopRepo.findFirstByProjectIdAndJobGroupAndState(scheduleEmailRequest.getProjectId(), Const.PROJECT_STOP,
                        Const.JOB_ACTIVE);
                if (startProject == null && endProject == null) {
                    //start project work
                    startProject = new SchedulerJobInfo(scheduleEmailRequest.getProjectId(), Const.PROJECT_START, EmailJob.class.toString(),
                            start, 0L, Const.JOB_ACTIVE);
                    schedulerJopRepo.save(startProject);
                    schedulerService.scheduleNewJob(startProject, "send invitation emails");

                    //end project work
                    endProject = new SchedulerJobInfo(scheduleEmailRequest.getProjectId(), Const.PROJECT_STOP, EmailJob.class.toString(),
                            end, 0L, Const.JOB_ACTIVE);
                    schedulerJopRepo.save(endProject);
                    schedulerService.scheduleNewJob(endProject, "send emails informing that project is closed for responses");
                } else if (startProject != null && endProject != null) {
                    endProject.setStartTime(end);
                    schedulerJopRepo.save(endProject);
                    schedulerService.updateScheduleJob(endProject);

                    startProject.setStartTime(start);
                    schedulerJopRepo.save(startProject);
                    schedulerService.updateScheduleJob(startProject);

                } else {
                    if (endProject != null) {
                        endProject.setStartTime(end);
                        schedulerJopRepo.save(endProject);
                        schedulerService.updateScheduleJob(endProject);
                    }
                }

                ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(true, "Email Scheduled Successfully!");
                return new ResponseEntity<>(scheduleEmailResponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(false,
                    "Error during parsing request!");
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>(scheduleEmailResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/EvaluateProject")
    public ResponseEntity<ScheduleEmailResponse> evaluateProject(@RequestBody Map<String, String> params) {
        evaluateService.evaluateProject(params.get("projectId"));
        ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(true, "Evaluating process for project started");
        return ResponseEntity.ok(scheduleEmailResponse);
    }

    @PostMapping("/RecallProject")
    public ResponseEntity recallProject(@RequestBody Map<String, String> params) {
        List<SchedulerJobInfo> projectJobs = schedulerJopRepo.findAllByProjectId(params.get("projectId"));
        if (projectJobs != null) {
            for (SchedulerJobInfo job : projectJobs) {
                schedulerService.unScheduleJob(job.getId());
                System.out.println("your job:" + job.getId() + " was deleted!!!");
            }
            ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(true, "your job was deleted!!!");
            return ResponseEntity.ok(scheduleEmailResponse);
        } else {
            return ResponseEntity.badRequest().body("No project jobs!");
        }
    }
}