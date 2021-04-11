package org.testplayground;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.BeforeALL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.testplayground.consumer.Employee;


@DisplayName("JUnit 5 Example")
public class SoapServiceUnitTest{

    MyEmpConsumer empConsumer = MyEmpConsumer.getInstance() ;

    @Test
    @DisplayName("spec")
    public void getSpecificEmpTest(){
        empConsumer = MyEmpConsumer.getInstance();
        int id = 99;
        Employee emp = empConsumer.getEmployeeById(99);
        String ssn = emp.getSsn();
        assertEquals(ssn,"N1212-1212-121dsfd");
    }


    @Test
    @DisplayName("save")
    public void SaveEmpTest(){
        empConsumer = MyEmpConsumer.getInstance();
        Employee emp = new Employee();
        emp.setFirstName("tesasast");
        emp.setLastName("test");
        emp.setSsn("edelo");

        Employee returnedEmp = empConsumer.saveEmployeeToDb(emp);

        System.out.println(returnedEmp.getId());

        Employee gotEmp = empConsumer.getEmployeeById(returnedEmp.getId());

        assertEquals(returnedEmp.getId(), gotEmp.getId());
    }

    
    // @Test
    // @DisplayName("Save With Consttraint")
    // public void SaveEmpCOnstraintesTest(){

        
    //     Assertions.assertThrows(Exception.class ,() ->{
    //         empConsumer = MyEmpConsumer.getInstance();
    //         Employee emp = new Employee();
    //         emp.setFirstName("a");
    //         emp.setLastName("test");
    //         emp.setSsn("edelo");
    //         Employee returnedEmp = empConsumer.saveEmployeeToDb(emp);
    //     });
    // }





    @Test
    @DisplayName("First ")
    public void firstTest() {
        System.out.println("yuyttu");
    }
 
    @Test
    @DisplayName("Second ")
    public void secondTest() {
        // assertEquals(7, 7);
        System.out.println("asdasd");
    }


}