package com.java.task.service;

import com.java.task.domain.Verification;
import com.java.task.domain.VerificationAction;
import com.java.task.entity.VerificationTask;

import java.util.Set;

public interface TaskService {

    public void createVerificationTask(Verification verification);

    public Set<VerificationTask> getTasksAssignedTo(Long empId);

    public VerificationTask changeTaskStatus(Long empId, Long taskId, VerificationAction action) throws Exception;

}
