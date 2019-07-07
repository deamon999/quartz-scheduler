package com.gmail.deamon999.scheduler.entity;

import com.gmail.deamon999.scheduler.Const;
import com.gmail.deamon999.scheduler.temp_models.AssignedUser;
import com.gmail.deamon999.scheduler.temp_models.EnterpriseData;
import com.gmail.deamon999.scheduler.temp_models.LocationData;
import com.gmail.deamon999.scheduler.temp_models.VendorMongo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

@Document(collection = "Projects")
public class ProjectModel {
    @Id
    private String id;
    @NotEmpty
    private String name;
    private String categoryId;
    private String creator;
    private String customerId;
    private String owner;
    private String status;
    private boolean enableStatus;
    private HashSet<LocationData> locations = new HashSet<>();
    private HashSet<EnterpriseData> enterpriseRequirements = new HashSet<>();
    private LinkedHashSet<VendorMongo> vendors = new LinkedHashSet<>();
    private Map<String, String> editorUsers = new HashMap<>();
    private HashSet<AssignedUser> assignedUsers = new HashSet<>();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modificationTime;

    public ProjectModel(String id, @NotEmpty String name, @NotEmpty String categoryId, String creator, String customerId,
                        String owner) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.creator = creator;
        this.customerId = customerId;
        this.owner = owner;
        this.status = Const.PROJECT_SETUP;
        this.enableStatus = true;
    }

    public ProjectModel(@NotEmpty String name, @NotEmpty String categoryId, String creator, String customerId, String owner) {
        this.name = name;
        this.categoryId = categoryId;
        this.creator = creator;
        this.customerId = customerId;
        this.owner = owner;
        this.status = Const.PROJECT_SETUP;
        this.enableStatus = true;
    }

    public ProjectModel() {
        this.enableStatus = true;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public HashSet<LocationData> getLocations() {
        return locations;
    }

    public void setLocations(HashSet<LocationData> locations) {
        this.locations = locations;
    }

    public HashSet<EnterpriseData> getEnterpriseRequirements() {
        return enterpriseRequirements;
    }

    public void setEnterpriseRequirements(HashSet<EnterpriseData> enterpriseRequirements) {
        this.enterpriseRequirements = enterpriseRequirements;
    }

    public LinkedHashSet<VendorMongo> getVendors() {
        return vendors;
    }

    public void setVendors(LinkedHashSet<VendorMongo> vendors) {
        this.vendors = vendors;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getEditorUsers() {
        return editorUsers;
    }

    public void setEditorUsers(Map<String, String> editorUsers) {
        this.editorUsers = editorUsers;
    }

    public HashSet<AssignedUser> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(HashSet<AssignedUser> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public boolean isEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(boolean enableStatus) {
        this.enableStatus = enableStatus;
    }

}
