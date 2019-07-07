package com.gmail.deamon999.scheduler.repository_mongo;

import com.gmail.deamon999.scheduler.entity.AcquisitionPlannerUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;


public interface AcquisitionPlannerUserRepo extends MongoRepository<AcquisitionPlannerUser, String> {
    AcquisitionPlannerUser findFirstById(String id);

    AcquisitionPlannerUser findFirstByEmail(String email);

    boolean existsByEmail(String email);

    AcquisitionPlannerUser findFirstByResetToken(String token);

    AcquisitionPlannerUser findFirstByRegisterToken(String token);

    AcquisitionPlannerUser findFirstByPhotoUri(String str);

    List<AcquisitionPlannerUser> findAllByOrganizationId(String id);

    Page<AcquisitionPlannerUser> findAllByOrganizationId(String id, Pageable pageable);

    Page<AcquisitionPlannerUser> findAllById(Set<String> id, Pageable pageable);

    long countAcquisitionPlannerUserByOrganizationId(String id);

    List<AcquisitionPlannerUser> findAllBy(TextCriteria criteria);

    Page<AcquisitionPlannerUser> findAllBy(TextCriteria criteria, Pageable pageable);

    AcquisitionPlannerUser findFirstByFirstNameAndLastName(String firstName, String lastName);

    List<AcquisitionPlannerUser> findAllByRoleModel(String roleModel);

    List<AcquisitionPlannerUser> findAllByRoleModelId(String id);

    boolean existsByPhotoUri(String uri);

}
