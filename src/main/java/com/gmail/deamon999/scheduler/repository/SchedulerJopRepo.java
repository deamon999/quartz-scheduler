package com.gmail.deamon999.scheduler.repository;

import com.gmail.deamon999.scheduler.entity.SchedulerJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerJopRepo extends JpaRepository<SchedulerJobInfo, Integer> {

    SchedulerJobInfo findFirstById(int id);

    SchedulerJobInfo findFirstByProjectIdAndJobGroupAndState(String projectId, String group, String state);

    List<SchedulerJobInfo> findAllByProjectId(String projectId);
}
