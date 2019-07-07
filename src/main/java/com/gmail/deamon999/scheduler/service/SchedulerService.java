package com.gmail.deamon999.scheduler.service;

import com.gmail.deamon999.scheduler.entity.SchedulerJobInfo;

public interface SchedulerService {

    void scheduleNewJob(SchedulerJobInfo jobInfo, String description);

    void updateScheduleJob(SchedulerJobInfo jobInfo);

    boolean unScheduleJob(int jobId);

    boolean deleteJob(SchedulerJobInfo jobInfo);

    boolean pauseJob(SchedulerJobInfo jobInfo);

    boolean resumeJob(SchedulerJobInfo jobInfo);

    boolean startJobNow(SchedulerJobInfo jobInfo);

}