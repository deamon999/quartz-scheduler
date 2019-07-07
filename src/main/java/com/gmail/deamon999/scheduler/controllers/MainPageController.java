package com.gmail.deamon999.scheduler.controllers;

import com.gmail.deamon999.scheduler.Const;
import com.gmail.deamon999.scheduler.entity.SchedulerJobInfo;
import com.gmail.deamon999.scheduler.repository.SchedulerJopRepo;
import com.gmail.deamon999.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.PushBuilder;
import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private SchedulerJopRepo schedulerJopRepo;
    @Autowired
    private SchedulerService schedulerService;

    @GetMapping("/")
    public String getMainPage(PushBuilder pushBuilder, Model model) {
        if (pushBuilder != null) {
            pushBuilder.path("/static/js/*").push();
            pushBuilder.path("/static/css/*").push();
            pushBuilder.path("/static/img/*").push();
            pushBuilder.path("/static/favicon.ico").push();
        }
        List<SchedulerJobInfo> jobs = schedulerJopRepo.findAll();
        model.addAttribute("jobs", jobs);
        return "index";
    }

    @GetMapping("/DeleteJob")
    public String deleteJob(@RequestParam("id") int jobId) {
        SchedulerJobInfo jobInfo = schedulerJopRepo.findFirstById(jobId);
        if (jobInfo != null) {
            schedulerService.deleteJob(jobInfo);
            schedulerJopRepo.delete(jobInfo);
        }
        return "redirect:/";
    }

    @GetMapping("/ChangeState")
    public String changeState(@RequestParam("s") String state, @RequestParam("id") int id) {
        SchedulerJobInfo jobInfo = schedulerJopRepo.findFirstById(id);
        if (jobInfo != null) {
            switch (state) {
                case Const.JOB_ACTIVE:
                    schedulerService.resumeJob(jobInfo);
                    jobInfo.setState(Const.JOB_ACTIVE);
                    break;
                case Const.JOB_PAUSE:
                    schedulerService.pauseJob(jobInfo);
                    jobInfo.setState(Const.JOB_PAUSE);
                    break;
                case Const.JOB_STOP:
                    schedulerService.unScheduleJob(jobInfo.getId());
                    jobInfo.setState(Const.JOB_STOP);
                    break;
            }
            schedulerJopRepo.save(jobInfo);
        }
        return "redirect:/";
    }
}
