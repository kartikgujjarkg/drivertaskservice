package com.java.task.repository;

import com.java.task.entity.VerificationTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface VerificationTaskRepository extends JpaRepository<VerificationTask, Long> {

    @Query(
            value = "SELECT * FROM verification_task WHERE assigned_to = ?1",
            nativeQuery = true)
    public Set<VerificationTask> findTasksAssignedTo(Long empId);

}
