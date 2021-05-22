package com.playground.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter @NoArgsConstructor
@ToString
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @NotEmpty
    @Size(min = 3, max  = 25, message = "Min is 3 Max is 25")
    @Column(name = "firstName")
    private String firstName;


    @NotEmpty
    @Size(min = 3, max  = 25, message = "Min is 3 Max is 25")
    @Column(name ="lastName")
    private String lastName;

    @Min(value = 1200, message = "The min. is 1200")
    @Column(name = "salary")
    private double salary;

    public Customer(String fname, String lname, double salary){
        firstName = fname;
        lastName = lname;
        this.salary = salary;
    }

}