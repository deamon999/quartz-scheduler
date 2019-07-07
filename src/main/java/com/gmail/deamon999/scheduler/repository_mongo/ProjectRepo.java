package com.gmail.deamon999.scheduler.repository_mongo;

import com.gmail.deamon999.scheduler.entity.ProjectModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProjectRepo extends MongoRepository<ProjectModel, String> {
    boolean existsByName(String name);

    ProjectModel findFirstById(String id);

    ProjectModel findFirstByNameAndCustomerId(String name, String customerId);

    @Query("{'assignedUsers':{$elemMatch: { 'userId': ?0}}}")
    List<ProjectModel> findAllByAssignedUsersContains(String id);

    @Query("{'assignedUsers':{$elemMatch: { 'userId': ?0}}}")
    Page<ProjectModel> findAllByAssignedUsersContains(String id, Pageable pageable);

    @Query("{'vendors':{$elemMatch: { 'id': ?0}}, 'enableStatus' : true}")
    List<ProjectModel> findAllByVendorsContaining(String vendorId);

    List<ProjectModel> findAllByCustomerId(String id);

    Page<ProjectModel> findAllByCustomerId(String id, Pageable pageable);

    long countAllByCustomerId(String id);

    long countAllByCustomerIdAndEnableStatus(String id, boolean enable);

    @Query("{'vendors':{$elemMatch: { 'id': ?0}}, 'enableStatus' : ?1}")
    List<ProjectModel> findAllByVendorsContainingAndEnableStatus(String id, boolean enable);

    List<ProjectModel> findAllByEnableStatus(boolean status);

    Page<ProjectModel> findAllByEnableStatus(boolean status, Pageable pageable);

    List<ProjectModel> findAllByStatus(String status);

    Page<ProjectModel> findAllByStatus(String status, Pageable pageable);

    @Query("{'vendors':{$elemMatch: { 'associates.newRole': { $exists: true }, 'associates.userId': ?0}}}")
    List<ProjectModel> findAllProjectForUser(String id);
}
