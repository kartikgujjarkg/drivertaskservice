package com.java.task.kafka;

import com.java.task.domain.Verification;
import com.java.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.java.task.constants.Constants.consumerGroupId;
import static com.java.task.constants.Constants.taskTopic;

@Service
public class KafkaConsumer {

    @Autowired
    TaskService taskService;

    @KafkaListener(topics = taskTopic, groupId = consumerGroupId)
    public void consumeVerificationTask(Verification verification){
        System.out.println("Recieved verification task from driver service");
        taskService.createVerificationTask(verification);
    }
}
