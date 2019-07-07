package com.gmail.deamon999.scheduler.temp_models;

import java.util.Objects;

public class AssignedUser {
    private String userId;
    private String organizationId;
    private int quantity;

    public AssignedUser(String id, String organizationId, int quantity) {
        this.userId = id;
        this.quantity = quantity;
        this.organizationId = organizationId;
    }

    public AssignedUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignedUser user = (AssignedUser) o;
        return quantity == user.quantity &&
                Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, quantity);
    }
}
