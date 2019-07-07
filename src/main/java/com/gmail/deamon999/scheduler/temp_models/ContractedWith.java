package com.gmail.deamon999.scheduler.temp_models;

import java.util.Objects;

public class ContractedWith {
    private String organizationId;
    private String role;

    public ContractedWith(String organizationId, String role) {
        this.organizationId = organizationId;
        this.role = role;
    }

    public ContractedWith() {
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractedWith that = (ContractedWith) o;
        return Objects.equals(organizationId, that.organizationId) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, role);
    }
}
