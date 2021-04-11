package org.testplayground;


import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;



import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @NoArgsConstructor @ToString
public class Emp{

    private int id;
    private String firstName;
    private String lastName;
    private String ssn;


    private List<MyLink> links;

}