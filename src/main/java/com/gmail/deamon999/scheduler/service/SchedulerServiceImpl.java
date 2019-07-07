package com.gmail.deamon999.scheduler.service;

import com.gmail.deamon999.scheduler.Const;
import com.gmail.deamon999.scheduler.entity.SchedulerJobInfo;
import com.gmail.deamon999.scheduler.jobs.EmailJob;
import com.gmail.deamon999.scheduler.repository.SchedulerJopRepo;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Date;

@Transactional
@Service
public class SchedulerServiceImpl implements SchedulerService {

    private Logger log = LoggerFactory.getLogger(SchedulerServiceImpl.class);
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private SchedulerJopRepo schedulerJopRepo;


    @Override
    public void scheduleNewJob(SchedulerJobInfo jobInfo, String description) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        ZonedDateTime dateTime = jobInfo.getStartTime();
        if (!dateTime.isBefore(ZonedDateTime.now())) {
            JobDetail jobDetail = buildJobDetail(jobInfo, description);
            Trigger trigger = buildJobTrigger(jobDetail, dateTime, description);
            try {
                scheduler.scheduleJob(jobDetail, trigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void updateScheduleJob(SchedulerJobInfo jobInfo) {
        ZonedDateTime dateTime = jobInfo.getStartTime();
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getJobName(), jobInfo.getJobGroup());
            //Trigger trigger = schedulerFactoryBean.getScheduler().getTrigger(triggerKey);
            JobDetail jobDetail = schedulerFactoryBean.getScheduler().getJobDetail(new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup()));
            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withIdentity(jobDetail.getKey().getName(), jobDetail.getKey().getGroup())
                    .withDescription(jobDetail.getDescription())
                    .startAt(Date.from(dateTime.toInstant()))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                    .build();
            schedulerFactoryBean.getScheduler().rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }


    @Override
    public boolean unScheduleJob(int jobId) {
        SchedulerJobInfo jobInfo = schedulerJopRepo.findFirstById(jobId);
        if (jobInfo != null) {
            try {
                jobInfo.setState(Const.JOB_STOP);
                schedulerJopRepo.save(jobInfo);
                return schedulerFactoryBean.getScheduler().unscheduleJob(new TriggerKey(jobInfo.getJobName(), jobInfo.getJobGroup()));
            } catch (SchedulerException e) {
                log.error("Failed to un-schedule job - {}", jobId, e);
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteJob(SchedulerJobInfo jobInfo) {
        try {
            schedulerJopRepo.delete(jobInfo);
            return schedulerFactoryBean.getScheduler().deleteJob(new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup()));
        } catch (SchedulerException e) {
            log.error("Failed to delete job - {}", jobInfo.getJobName(), e);
            return false;
        }
    }

    @Override
    public boolean pauseJob(SchedulerJobInfo jobInfo) {
        try {
            jobInfo.setState(Const.JOB_PAUSE);
            schedulerJopRepo.save(jobInfo);
            schedulerFactoryBean.getScheduler().pauseJob(new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup()));
            return true;
        } catch (SchedulerException e) {
            log.error("Failed to pause job - {}", jobInfo.getJobName(), e);
            return false;
        }
    }

    @Override
    public boolean resumeJob(SchedulerJobInfo jobInfo) {
        try {
            jobInfo.setState(Const.JOB_ACTIVE);
            schedulerJopRepo.save(jobInfo);
            schedulerFactoryBean.getScheduler().resumeJob(new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup()));
            return true;
        } catch (SchedulerException e) {
            log.error("Failed to resume job - {}", jobInfo.getJobName(), e);
            return false;
        }
    }

    @Override
    public boolean startJobNow(SchedulerJobInfo jobInfo) {
        try {
            jobInfo.setState(Const.JOB_ACTIVE);
            schedulerJopRepo.save(jobInfo);
            schedulerFactoryBean.getScheduler().triggerJob(new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup()));
            return true;
        } catch (SchedulerException e) {
            log.error("Failed to start new job - {}", jobInfo.getJobName(), e);
            return false;
        }
    }

    private JobDetail buildJobDetail(SchedulerJobInfo jobInfo, String description) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("projectId", jobInfo.getProjectId());
        jobDataMap.put("jobId", jobInfo.getId());
        jobDataMap.put("group", jobInfo.getJobGroup());

        return JobBuilder.newJob(EmailJob.class)
                .withIdentity(jobInfo.getJobName(), jobInfo.getJobGroup())
                .withDescription(description)
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt, String description) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), jobDetail.getKey().getGroup())
                .withDescription(description)
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
}
