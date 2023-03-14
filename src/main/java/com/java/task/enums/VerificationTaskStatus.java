package com.java.task.enums;

import lombok.Getter;
@Getter
public enum VerificationTaskStatus {
    ASSIGNED("ASSIGNED"),
    INPROGRESS("INPROGRESS"),
    APPROVED("APPROVED"),
    DECLINED("DECLINED");

    String value;

    VerificationTaskStatus(String value){
        this.value = value;
    }

}