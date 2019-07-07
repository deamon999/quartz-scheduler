package com.gmail.deamon999.scheduler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.deamon999.scheduler.temp_models.ContractedWith;
import com.gmail.deamon999.scheduler.temp_models.PhoneNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;

@Document(collection = "Users")
public class AcquisitionPlannerUser {
    @Id
    private String id;
    @TextIndexed
    private String firstName;
    @TextIndexed
    private String middleName;
    @TextIndexed
    private String lastName;
    private String title;
    @TextIndexed
    @Indexed(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String roleModel;
    @JsonIgnore
    private String roleModelId;
    @JsonIgnore
    private String superiorId;
    private String superiorName;
    private String organizationName;
    @JsonIgnore
    @TextIndexed
    private String organizationId;
    private String langCode;
    @JsonIgnore
    private String resetToken;
    @JsonIgnore
    private String registerToken;
    @JsonIgnore
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date tokenCreationTime;
    @JsonIgnore
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date registerTokenCreationTime;
    private String photoUri;
    private HashSet<ContractedWith> contractedWithSet = new HashSet<>();
    private HashSet<PhoneNumber> phoneNumbers = new HashSet<>();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modificationTime;

    public AcquisitionPlannerUser(String id, String firstName, String middleName, String lastName, String title,
                                  String email, String password, String roleModel, String roleModelId, String superiorId,
                                  String superiorName, String organizationName, String organizationId) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.password = password;
        this.roleModel = roleModel;
        this.roleModelId = roleModelId;
        this.superiorId = superiorId;
        this.superiorName = superiorName;
        this.organizationName = organizationName;
        this.organizationId = organizationId;
    }

    public AcquisitionPlannerUser(String firstName, String middleName, String lastName, String title, String email,
                                  String password, String roleModel, String roleModelId, String superiorId, String superiorName,
                                  String organizationName, String organizationId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.password = password;
        this.roleModel = roleModel;
        this.roleModelId = roleModelId;
        this.superiorId = superiorId;
        this.superiorName = superiorName;
        this.organizationName = organizationName;
        this.organizationId = organizationId;
    }

    public AcquisitionPlannerUser() {
    }

    public String getRoleModelId() {
        return roleModelId;
    }

    public void setRoleModelId(String roleModelId) {
        this.roleModelId = roleModelId;
    }

    public String getSuperiorName() {
        return superiorName;
    }

    public void setSuperiorName(String superiorName) {
        this.superiorName = superiorName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(String roleModel) {
        this.roleModel = roleModel;
    }

    public String getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(String superiorId) {
        this.superiorId = superiorId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Date getTokenCreationTime() {
        return tokenCreationTime;
    }

    public void setTokenCreationTime(Date tokenCreationTime) {
        this.tokenCreationTime = tokenCreationTime;
    }

    public HashSet<ContractedWith> getContractedWithSet() {
        return contractedWithSet;
    }

    public void setContractedWithSet(HashSet<ContractedWith> contractedWithSet) {
        this.contractedWithSet = contractedWithSet;
    }

    public HashSet<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(HashSet<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getRegisterToken() {
        return registerToken;
    }

    public void setRegisterToken(String registerToken) {
        this.registerToken = registerToken;
    }

    public Date getRegisterTokenCreationTime() {
        return registerTokenCreationTime;
    }

    public void setRegisterTokenCreationTime(Date registerTokenCreationTime) {
        this.registerTokenCreationTime = registerTokenCreationTime;
    }
}
