package com.java.task.controller;

import com.java.task.domain.Comment;
import com.java.task.domain.VerificationAction;
import com.java.task.entity.VerificationTask;
import com.java.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/uber/tasks")
public class TaskContoller {

    @Autowired
    TaskService taskService;

    @GetMapping("/assigned-tasks/approver/{empId}")
    public ResponseEntity<Set<VerificationTask>> getTasksAssignedTo(@PathVariable("empId") Long empId){
        Set<VerificationTask> verficationTaskList = taskService.getTasksAssignedTo(empId);
        return new ResponseEntity<>(verficationTaskList, HttpStatus.OK);
    }

   /* @PatchMapping("/accept-task/approver/{empId}/task/{taskId}")
    public ResponseEntity<VerificationTask> acceptTask(@PathVariable("empId") Long empId, @PathVariable("taskId") Long taskId) throws Exception {
        VerificationTask verificationTask = taskService.acceptTask(empId,taskId);
        return new ResponseEntity<>(verificationTask, HttpStatus.OK);
    }

    @PatchMapping("/approve-task/approver/{empId}/task/{taskId}")
    public ResponseEntity<VerificationTask> approveTask(@PathVariable("empId") Long empId, @PathVariable("taskId") Long taskId) throws Exception {
        VerificationTask verificationTask = taskService.approveTask(empId,taskId);
        return new ResponseEntity<>(verificationTask, HttpStatus.OK);
    };

    @PatchMapping("/decline-task/approver/{empId}/task/{taskId}")
    public ResponseEntity<VerificationTask> declineTask(@PathVariable("empId") Long empId, @PathVariable("taskId") Long taskId, @RequestBody Comment comment) throws Exception {
        VerificationTask verificationTask = taskService.declineTask(empId,taskId,comment.getComment());
        return new ResponseEntity<>(verificationTask, HttpStatus.OK);
    }*/

    @PatchMapping("/approver/{empId}/task/{taskId}")
    public ResponseEntity<VerificationTask> changeTaskStatus(@PathVariable("empId") Long empId, @PathVariable("taskId") Long taskId, @RequestBody VerificationAction action) throws Exception {
        VerificationTask verificationTask = taskService.changeTaskStatus(empId,taskId,action);
        return new ResponseEntity<>(verificationTask, HttpStatus.OK);
    }
}
