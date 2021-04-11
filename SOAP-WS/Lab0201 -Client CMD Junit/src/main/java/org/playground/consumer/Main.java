package org.playground.consumer;

import org.playground.consumer.generated.Employee;

public class Main{


    public static void main(String [] args){
        System.out.println("=================Hello========================");
        
        MyEmpConsumer empConsumer = MyEmpConsumer.getInstance();

        // ADDING NEW EMPLOYEE TO DB >>>>>>>>
        Employee newEmp = new Employee();
        newEmp.setFirstName("New Emp");
        newEmp.setLastName("New Emp");
        newEmp.setSsn("N1212-1212-121dsfd");

        empConsumer.saveEmployeeToDb(newEmp);

    } 
}