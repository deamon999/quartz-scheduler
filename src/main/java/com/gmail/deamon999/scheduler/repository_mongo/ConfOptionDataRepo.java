package com.gmail.deamon999.scheduler.repository_mongo;

import com.gmail.deamon999.scheduler.entity.ConfOptionDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConfOptionDataRepo extends MongoRepository<ConfOptionDataModel, String> {
    List<ConfOptionDataModel> findAllByConfigurationModelId(String id);

    ConfOptionDataModel findFirstById(String configurationOptionId);

    void deleteAllByConfigurationModelId(String id);

    List<ConfOptionDataModel> findAllByConfigurationModelIdAndCharacteristicOptionMongoId(String configurationId, String characteristicId);
}
