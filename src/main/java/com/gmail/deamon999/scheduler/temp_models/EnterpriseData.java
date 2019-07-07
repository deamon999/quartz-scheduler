package com.gmail.deamon999.scheduler.temp_models;

import java.util.Objects;
import java.util.Set;

public class EnterpriseData {
    private String requirementId;
    private String requirementName;
    private Set<String> users;

    public EnterpriseData(String requirementId, String requirementName, Set<String> users) {
        this.requirementId = requirementId;
        this.users = users;
        this.requirementName = requirementName;
    }

    public EnterpriseData() {
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterpriseData data = (EnterpriseData) o;
        return Objects.equals(requirementId, data.requirementId) &&
                Objects.equals(users, data.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requirementId, users);
    }
}
