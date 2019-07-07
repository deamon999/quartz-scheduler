package com.gmail.deamon999.scheduler.repository_mongo;

import com.gmail.deamon999.scheduler.entity.ConfigurationDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConfigurationDataRepo extends MongoRepository<ConfigurationDataModel, String> {
    ConfigurationDataModel findFirstByProjectIdAndRequirementTypeMongoIdAndSystemComponentMongoId(String projectModelId, String requirementTypeMongoId,
                                                                                                  String systemComponentMongoId);

    ConfigurationDataModel findFirstByNameAndProjectIdAndSystemComponentMongoIdAndDepartmentDataModelId(String configurationName, String projectId,
                                                                                                        String systemComponentId, String departmentId);

    ConfigurationDataModel findFirstById(String configurationId);

    List<ConfigurationDataModel> findAllByRequirementTypeMongoIdAndProjectId(String requirementId, String projectId);

    List<ConfigurationDataModel> findAllByDepartmentDataModelIdAndLocationDataModelIdAndProjectId(String departmentId, String locationId, String projectId);

    List<ConfigurationDataModel> findAllByDepartmentDataModelIdAndLocationDataModelIdAndProjectIdAndSystemComponentMongoId(String departmentId,
                                                                                                                           String locationId,
                                                                                                                           String projectId,
                                                                                                                           String sysCompId);

    List<ConfigurationDataModel> findAllByProjectIdAndSystemComponentMongoId(String projectId, String systemCompId);

    List<ConfigurationDataModel> findAllByProjectId(String id);

    List<ConfigurationDataModel> findAllByProjectIdAndLocationDataModelId(String id, String locationId);

    void deleteAllByProjectIdAndLocationDataModelId(String id, String locationId);

    List<ConfigurationDataModel> findAllByDepartmentDataModelIdAndProjectId(String departmentId, String projectId);

    List<ConfigurationDataModel> findAllByProjectIdAndDepartmentDataModelId(String projectId, String departmentId);

    ConfigurationDataModel findFirstByProjectIdAndRequirementTypeMongoId(String projectId, String requirementId);
}
