package com.gmail.deamon999.scheduler.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

@Document("ConfigurationData")
public class ConfigurationDataModel {
    @Id
    private String id;
    @NotEmpty
    private String projectId;
    private String locationDataModelId;
    private String locationName;
    private String departmentDataModelId;
    private String departmentName;
    private String requirementTypeMongoId;
    private String requirementName;
    @NotEmpty
    private String systemComponentMongoId;
    private String systemComponentName;
    private String name;
    private Map<String, Double> prices = new HashMap<>();
    private int quantity;

    public ConfigurationDataModel(String id, String projectId, String locationDataModelId, String departmentDataModelId, String requirementTypeMongoId,
                                  String systemComponentMongoId, String name, int quantity, String locationName, String departmentName, String requirementName,
                                  String systemComponentName) {
        this.id = id;
        this.projectId = projectId;
        this.locationDataModelId = locationDataModelId;
        this.departmentDataModelId = departmentDataModelId;
        this.requirementTypeMongoId = requirementTypeMongoId;
        this.systemComponentMongoId = systemComponentMongoId;
        this.name = name;
        this.quantity = quantity;
        this.locationName = locationName;
        this.departmentName = departmentName;
        this.requirementName = requirementName;
        this.systemComponentName = systemComponentName;
    }

    public ConfigurationDataModel(String projectId, String locationDataModelId, String departmentDataModelId, String requirementTypeMongoId,
                                  String systemComponentMongoId, String name, int quantity, String locationName, String departmentName, String requirementName,
                                  String systemComponentName) {
        this.projectId = projectId;
        this.locationDataModelId = locationDataModelId;
        this.departmentDataModelId = departmentDataModelId;
        this.requirementTypeMongoId = requirementTypeMongoId;
        this.systemComponentMongoId = systemComponentMongoId;
        this.name = name;
        this.quantity = quantity;
        this.locationName = locationName;
        this.departmentName = departmentName;
        this.requirementName = requirementName;
        this.systemComponentName = systemComponentName;
    }

    public ConfigurationDataModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getLocationDataModelId() {
        return locationDataModelId;
    }

    public void setLocationDataModelId(String locationDataModelId) {
        this.locationDataModelId = locationDataModelId;
    }

    public String getDepartmentDataModelId() {
        return departmentDataModelId;
    }

    public void setDepartmentDataModelId(String departmentDataModelId) {
        this.departmentDataModelId = departmentDataModelId;
    }

    public String getRequirementTypeMongoId() {
        return requirementTypeMongoId;
    }

    public void setRequirementTypeMongoId(String requirementTypeMongoId) {
        this.requirementTypeMongoId = requirementTypeMongoId;
    }

    public String getSystemComponentMongoId() {
        return systemComponentMongoId;
    }

    public void setSystemComponentMongoId(String systemComponentMongoId) {
        this.systemComponentMongoId = systemComponentMongoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getSystemComponentName() {
        return systemComponentName;
    }

    public void setSystemComponentName(String systemComponentName) {
        this.systemComponentName = systemComponentName;
    }
}
