package com.gmail.deamon999.scheduler.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleEmailResponse {
    private boolean success;
    private String message;

    public ScheduleEmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}