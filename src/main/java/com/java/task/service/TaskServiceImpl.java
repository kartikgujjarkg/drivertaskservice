package com.java.task.service;

import com.java.task.domain.Verification;
import com.java.task.domain.VerificationAction;
import com.java.task.entity.VerificationTask;
import com.java.task.enums.VerificationTaskStatus;
import com.java.task.repository.VerificationTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    VerificationTaskRepository verificationTaskRepository;

    @Autowired
    NotifiyDriverService notifiyDriverService;

    public void createVerificationTask(Verification verification) {
        Random random = new Random();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        VerificationTask task = new VerificationTask();
        task.setVerificationType(verification.getVerificationType());
        task.setVerificationTaskStatus(VerificationTaskStatus.ASSIGNED.getValue());
        task.setAssignedTo(random.nextLong(10));
        task.setVerificationFileUrl(verification.getVerificationFileUrl());
        task.setVerificationId(verification.getId());
        task.setDriverId(verification.getDriver().getId());
        task.setCreatedAt(timestamp);
        task.setUpdatedAt(timestamp);
        verificationTaskRepository.save(task);
    }

    public Set<VerificationTask> getTasksAssignedTo(Long empId) {
        return verificationTaskRepository.findTasksAssignedTo(empId);
    }
    public VerificationTask changeTaskStatus(Long empId, Long taskId, VerificationAction action) throws Exception {
        Optional<VerificationTask> verificationTaskOptional = verificationTaskRepository.findById(taskId);
        if(!verificationTaskOptional.isPresent()){
            throw new Exception("Task not found");
        }
        VerificationTask currentVerificationTask = verificationTaskOptional.get();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        setStatusforVerificationTask(currentVerificationTask, action);
        currentVerificationTask.setUpdatedAt(timestamp);
        currentVerificationTask.setComment(action.getComment());
        notifiyDriverService.notifyDriverService(currentVerificationTask);
        return verificationTaskRepository.save(currentVerificationTask);
    }

    public void setStatusforVerificationTask(VerificationTask currentVerificationTask, VerificationAction action) throws Exception {
        String status = action.getAction().trim().toUpperCase();
        for(VerificationTaskStatus verificationTaskStatus :VerificationTaskStatus.values()){
            if(verificationTaskStatus.getValue().equals(status)){
                currentVerificationTask.setVerificationTaskStatus(verificationTaskStatus.getValue());
                return;
            };
        }
        throw new Exception("Invalid verification status");
    }


}
