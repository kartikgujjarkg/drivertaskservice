package com.java.task.service;

import com.java.task.domain.Verification;
import com.java.task.entity.VerificationTask;
import com.java.task.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyDriverServiceImpl implements NotifiyDriverService {

    @Autowired
    KafkaProducer kafkaProducer;

    public void notifyDriverService(VerificationTask verificationTask){
        Verification verification = new Verification();
        verification.setId(verificationTask.getVerificationId());
        verification.setVerificationStatus(verificationTask.getVerificationTaskStatus());
        verification.setComment(verificationTask.getComment());
        kafkaProducer.sendUpdateMessageToDriverService(verification);
    }

}
