package org.testplayground;

import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.BeforeALL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;
import com.google.gson.*;

@DisplayName("JUnit 5 Example")
public class RestServiceUnitTest{

    Client restClient = ClientBuilder.newClient();

    @Test
    @DisplayName("spec")
    public void getSpecificEmpTest(){

        Emp emp = restClient
                    .target("http://localhost:9191/REST-D2/api/emps")
                    .path("{id}")
                    .resolveTemplate("id", 4)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Emp.class);


        assertEquals(emp.getSsn(), "45345");

        System.out.println(emp);
       
    }


    @Test
    @DisplayName("save")
    public void SaveEmpTest(){
        List<Emp> emps = restClient
        .target("http://localhost:9191/REST-D2/api/emps")
        .request(MediaType.APPLICATION_JSON)
        .get( new GenericType<List<Emp>>(){} );

        System.out.println(emps);

    }


    // @Test
    // @DisplayName("First ")
    // public void firstTest() {
    //     System.out.println("yuyttu");
    // }
 
    // @Test
    // @DisplayName("Second ")
    // public void secondTest() {
    //     // assertEquals(7, 7);
    //     System.out.println("asdasd");
    // }


}