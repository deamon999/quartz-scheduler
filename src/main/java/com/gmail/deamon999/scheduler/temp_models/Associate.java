package com.gmail.deamon999.scheduler.temp_models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Associate {
    private String userId;
    private String role;
    private String newRole;
    private String status;
    private String inviterId;
    private LocalDateTime transferTime;

    public Associate(String userId, String role, String newRole, String status, String inviterId, LocalDateTime transferTime) {
        this.userId = userId;
        this.role = role;
        this.newRole = newRole;
        this.status = status;
        this.inviterId = inviterId;
        this.transferTime = transferTime;
    }

    public Associate() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public LocalDateTime getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(LocalDateTime transferTime) {
        this.transferTime = transferTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Associate associate = (Associate) o;
        return Objects.equals(getUserId(), associate.getUserId()) &&
                Objects.equals(getRole(), associate.getRole()) &&
                Objects.equals(getNewRole(), associate.getNewRole()) &&
                Objects.equals(getStatus(), associate.getStatus()) &&
                Objects.equals(getInviterId(), associate.getInviterId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getRole(), getNewRole(), getStatus(), getInviterId());
    }
}
