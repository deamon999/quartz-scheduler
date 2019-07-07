package com.gmail.deamon999.scheduler.entity;

import com.gmail.deamon999.scheduler.temp_models.ResponseData;
import com.gmail.deamon999.scheduler.temp_models.Selections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

@Document("ConfigurationOptionData")
public class ConfOptionDataModel {
    @Id
    private String id;
    @NotEmpty
    private String characteristicOptionMongoId;
    private String characteristicOptionName;
    @NotEmpty
    private String componentCharMongoId;
    private String componentCharName;
    @NotEmpty
    private String configurationModelId;
    private int importance;
    private String state;
    private String vendorState;
    private Selections values;
    private Map<String, ResponseData> responseMap = new HashMap<>();

    public ConfOptionDataModel(String id, String characteristicOptionMongoId, String componentCharMongoId, String configurationModelId,
                               int importance, String state, String vendorState, Selections values, String characteristicOptionName, String componentCharName) {
        this.id = id;
        this.characteristicOptionMongoId = characteristicOptionMongoId;
        this.componentCharMongoId = componentCharMongoId;
        this.configurationModelId = configurationModelId;
        this.importance = importance;
        this.state = state;
        this.vendorState = vendorState;
        this.values = values;
        this.characteristicOptionName = characteristicOptionName;
        this.componentCharName = componentCharName;
    }

    public ConfOptionDataModel(String characteristicOptionMongoId, String componentCharMongoId, String configurationModelId, int importance,
                               String state, String vendorState, Selections values, String characteristicOptionName, String componentCharName) {
        this.characteristicOptionMongoId = characteristicOptionMongoId;
        this.componentCharMongoId = componentCharMongoId;
        this.configurationModelId = configurationModelId;
        this.importance = importance;
        this.state = state;
        this.vendorState = vendorState;
        this.values = values;
        this.characteristicOptionName = characteristicOptionName;
        this.componentCharName = componentCharName;
    }

    public ConfOptionDataModel(String characteristicOptionMongoId, String componentCharMongoId, String configurationModelId, int importance, Selections values,
                               String characteristicOptionName, String componentCharName) {
        this.characteristicOptionMongoId = characteristicOptionMongoId;
        this.componentCharMongoId = componentCharMongoId;
        this.configurationModelId = configurationModelId;
        this.importance = importance;
        this.values = values;
        this.characteristicOptionName = characteristicOptionName;
        this.componentCharName = componentCharName;
    }

    public ConfOptionDataModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacteristicOptionMongoId() {
        return characteristicOptionMongoId;
    }

    public void setCharacteristicOptionMongoId(String characteristicOptionMongoId) {
        this.characteristicOptionMongoId = characteristicOptionMongoId;
    }

    public String getComponentCharMongoId() {
        return componentCharMongoId;
    }

    public void setComponentCharMongoId(String componentCharMongoId) {
        this.componentCharMongoId = componentCharMongoId;
    }

    public String getConfigurationModelId() {
        return configurationModelId;
    }

    public void setConfigurationModelId(String configurationModelId) {
        this.configurationModelId = configurationModelId;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVendorState() {
        return vendorState;
    }

    public void setVendorState(String vendorState) {
        this.vendorState = vendorState;
    }

    public Selections getValues() {
        return values;
    }

    public void setValues(Selections values) {
        this.values = values;
    }

    public Map<String, ResponseData> getResponseMap() {
        return responseMap;
    }

    public void setResponseMap(Map<String, ResponseData> responseMap) {
        this.responseMap = responseMap;
    }

    public String getCharacteristicOptionName() {
        return characteristicOptionName;
    }

    public void setCharacteristicOptionName(String characteristicOptionName) {
        this.characteristicOptionName = characteristicOptionName;
    }

    public String getComponentCharName() {
        return componentCharName;
    }

    public void setComponentCharName(String componentCharName) {
        this.componentCharName = componentCharName;
    }
}
