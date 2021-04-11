package org.playground.resources.exceptions;

import jakarta.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter @NoArgsConstructor 
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage{

    private int errorCode;
    private String errorMsg;
    private String errDescription;



}