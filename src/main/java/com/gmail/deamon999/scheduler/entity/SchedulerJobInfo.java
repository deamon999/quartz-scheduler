package com.gmail.deamon999.scheduler.entity;


import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(catalog = "quartz_demo_db", name = "scheduler_job_info")
public class SchedulerJobInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectId;
    private String jobName;
    private String jobGroup;
    private String jobClass;
    private ZonedDateTime startTime;
    private Long repeatTime;
    private String state;

    public SchedulerJobInfo(String projectId, String jobGroup, String jobClass,
                            ZonedDateTime startTime, Long repeatTime, String state) {
        this.projectId = projectId;
        this.jobGroup = jobGroup;
        this.jobClass = jobClass;
        this.startTime = startTime;
        this.repeatTime = repeatTime;
        this.state = state;
        this.jobName = UUID.randomUUID().toString();
    }

    public SchedulerJobInfo() {
        jobName = UUID.randomUUID().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(Long repeatTime) {
        this.repeatTime = repeatTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
