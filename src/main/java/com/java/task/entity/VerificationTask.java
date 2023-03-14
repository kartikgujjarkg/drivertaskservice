package com.java.task.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "verification_task")
public class VerificationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="driver_id", nullable = false)
    private Long driverId;

    @Column(name = "verification_type", nullable = false, length = 40)
    private String verificationType;

    @Column(name = "verification_file_url", length = 200)
    private String verificationFileUrl;

    @Column(name = "verification_task_status", nullable = false, length = 20)
    private String verificationTaskStatus;

    @Column(name= "verification_id", nullable = false)
    private Long verificationId;

    @Column(name= "assigned_to",nullable = false)
    private Long assignedTo;

    @Column(name = "comment",length =400)
    private String comment;

    @Column(name = "created_at",nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at",nullable = false)
    private Timestamp updatedAt;

}
