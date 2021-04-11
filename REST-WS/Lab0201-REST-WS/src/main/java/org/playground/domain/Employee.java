package org.playground.domain;


import javax.persistence.*;
// import javax.validation.constraints.Size;
import java.util.Date;

import jakarta.xml.bind.annotation.*;



@Entity(name="employee")
@Table(name = "employee", catalog = "webservicedb" , schema = "webservicedb")
@XmlRootElement(name ="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    public Employee(){}

    public Employee(String fname, String lname, String ssn){
        firstName = fname;
        lastName = lname;
        this.ssn = ssn;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlElement(name = "id")
    private Integer id;

    @Column(name = "first_name")
    // @Size(min = 5, max = 15, message = "Error Inputing the FNAME")
    @XmlElement(name = "firstName")
    private String firstName;

    @Column(name = "last_name")
    @XmlElement(name = "lastName")
    private String lastName;

    @Column(name = "ssn")
    @XmlElement(name = "ssn")
    private String ssn;

    
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }


    public String  getFirstName(){
        return firstName;
    }

    public void setFirstName(String str){
        this.firstName = str;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String str){
        this.lastName = str;
    }

    public String getSsn(){
        return ssn;
    }

    public void setSsn(String ssn){
        this.ssn = ssn;
    }


}
