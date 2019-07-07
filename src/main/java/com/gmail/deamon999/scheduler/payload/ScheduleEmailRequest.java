package com.gmail.deamon999.scheduler.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ScheduleEmailRequest {

    @NotEmpty
    private String projectId;
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;

    public ScheduleEmailRequest(@NotEmpty String projectId, @NotNull String startTime, @NotNull String endTime) {
        this.projectId = projectId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ScheduleEmailRequest() {
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
