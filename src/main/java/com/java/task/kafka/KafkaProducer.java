package com.java.task.kafka;

import com.java.task.domain.Verification;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.java.task.constants.Constants.taskUpdateTopic;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUpdateMessageToDriverService(Verification verification){
        this.kafkaTemplate.send(taskUpdateTopic,verification);
        System.out.println("Sent Kakfa message");
    }
}
