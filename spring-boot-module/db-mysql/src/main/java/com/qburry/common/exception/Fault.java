package com.qburry.common.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Fault {
    private FaultType faultType;
    private String message;
}
