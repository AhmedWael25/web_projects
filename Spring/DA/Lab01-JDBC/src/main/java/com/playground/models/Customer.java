package com.playground.models;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter @Setter @NoArgsConstructor
@ToString 
public class Customer {

    private  int id;

    @NotEmpty
    @Size(min = 3, max  = 25, message = "Min is 3 Max is 25")
    private String firstName;


    @NotEmpty
    @Size(min = 3, max  = 25, message = "Min is 3 Max is 25")
    private String lastName;

    @Min(value = 1200, message = "The min. is 1200")
    private double salary;

    public Customer(String fname, String lname, double salary){
        firstName = fname;
        lastName = lname;
        this.salary = salary;
    }

}