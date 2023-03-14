package com.java.task.domain;

import jakarta.persistence.*;
import lombok.Data;



@Data
public class Verification {

    private Long id;
    private String verificationType;
    private String verificationStatus;
    private String verificationFileUrl;
    private String comment;
    private Driver driver;


}
