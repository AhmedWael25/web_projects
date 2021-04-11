package org.playground.resources.models;


import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.ws.rs.core.Link;

import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @NoArgsConstructor 
public class EmpDto{

    private int id;
    private String firstName;
    private String lastName;
    private String ssn;


    private List<MyLink> links;

}