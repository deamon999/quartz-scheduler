package com.gmail.deamon999.scheduler.service;

import com.gmail.deamon999.scheduler.entity.ConfOptionDataModel;
import com.gmail.deamon999.scheduler.entity.ConfigurationDataModel;
import com.gmail.deamon999.scheduler.entity.ProjectModel;
import com.gmail.deamon999.scheduler.repository_mongo.AcquisitionPlannerUserRepo;
import com.gmail.deamon999.scheduler.repository_mongo.ConfOptionDataRepo;
import com.gmail.deamon999.scheduler.repository_mongo.ConfigurationDataRepo;
import com.gmail.deamon999.scheduler.repository_mongo.ProjectRepo;
import com.gmail.deamon999.scheduler.temp_models.ResponseData;
import com.gmail.deamon999.scheduler.temp_models.VendorMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluateService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private AcquisitionPlannerUserRepo acquisitionPlannerUserRepo;
    @Autowired
    private ConfigurationDataRepo configurationDataRepo;
    @Autowired
    private ConfOptionDataRepo confOptionDataRepo;

    public void evaluateProject(String projectId) {
        ProjectModel projectModel = projectRepo.findFirstById(projectId);
        if (projectModel != null) {
            Map<String, Double> result = new HashMap<>();

            Set<VendorMongo> vendorMongoSet = projectModel.getVendors();
            Set<String> vendorIds = new HashSet<>();
            for (VendorMongo vendorMongo : vendorMongoSet) {
                vendorIds.add(vendorMongo.getId());
            }

            List<ConfigurationDataModel> configurationDataModelList = configurationDataRepo.findAllByProjectId(projectModel.getId());
            for (ConfigurationDataModel model : configurationDataModelList) {
                List<ConfOptionDataModel> confOptionDataModelList = confOptionDataRepo.findAllByConfigurationModelId(model.getId());
                for (ConfOptionDataModel confOptionDataModel : confOptionDataModelList) {
                    Map<String, ResponseData> vendorResponse = confOptionDataModel.getResponseMap();
                    for (String str : vendorIds) {
                        if (vendorResponse.containsKey(str)) {
                            double score = 0d;
                            if (result.containsKey(str)) {
                                score = result.get(str);
                                ResponseData responseData = vendorResponse.get(str);
                                switch (responseData.getCompliance()) {
                                    case 1:
                                        score += 1d;
                                        break;
                                    case 2:
                                        score += 0.5d;
                                        break;
                                    case 3:
                                        score += 0;
                                        break;
                                }
                                result.put(str, score);
                            } else {
                                ResponseData responseData = vendorResponse.get(str);
                                switch (responseData.getCompliance()) {
                                    case 1:
                                        score += 1d;
                                        break;
                                    case 2:
                                        score += 0.5d;
                                        break;
                                    case 3:
                                        score += 0;
                                        break;
                                }
                                result.put(str, score);
                            }
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
