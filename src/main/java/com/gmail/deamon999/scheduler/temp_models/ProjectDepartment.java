package com.gmail.deamon999.scheduler.temp_models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProjectDepartment {
    private String departmentId;
    private String departmentName;
    private Set<String> users = new HashSet<>();

    public ProjectDepartment(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public ProjectDepartment() {
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDepartment that = (ProjectDepartment) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, users);
    }
}
