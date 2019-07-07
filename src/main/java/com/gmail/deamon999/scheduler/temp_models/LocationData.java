package com.gmail.deamon999.scheduler.temp_models;

import java.util.HashSet;
import java.util.Objects;

public class LocationData {
    private String locationId;
    private String locationName;
    private HashSet<ProjectDepartment> departments;

    public LocationData(String locationId, String locationName, HashSet<ProjectDepartment> departments) {
        this.locationId = locationId;
        this.departments = departments;
        this.locationName = locationName;
    }

    public LocationData() {
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public HashSet<ProjectDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(HashSet<ProjectDepartment> departments) {
        this.departments = departments;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationData that = (LocationData) o;
        return Objects.equals(locationId, that.locationId) &&
                Objects.equals(departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, departments);
    }
}
