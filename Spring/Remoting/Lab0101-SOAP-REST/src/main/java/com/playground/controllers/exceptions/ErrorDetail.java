package com.playground.controllers.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter @Getter @NoArgsConstructor
public class ErrorDetail {
    private String errCode;
    private String errMsg;
    private Map<String, Object> additionalDta = new HashMap<>();

}
