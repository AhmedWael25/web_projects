package org.testplayground;

import org.testplayground.consumer.Employee;
import org.testplayground.consumer.EmployeeImplService;

import org.testplayground.consumer.EmployeeDao;


public class MyEmpConsumer{


    public static MyEmpConsumer instance = new MyEmpConsumer();

    private EmployeeDao employeeAccessObj;

    private MyEmpConsumer(){
        EmployeeImplService employeeImplService = new EmployeeImplService();
        employeeAccessObj = employeeImplService.getEmployeeImplPort();
    }

    public static MyEmpConsumer getInstance(){
        return instance;
    }

    public Employee getEmployeeById(int id){
        return employeeAccessObj.getEmployeeById(id);
    }

    public Employee saveEmployeeToDb(Employee emp){
        return employeeAccessObj.saveEmployee(emp);
    }

    public void deleteEmployeeById(int id){
        employeeAccessObj.deleteEmployeeById(id);
    }

    public Employee updateEmployee(Employee emp){
        return employeeAccessObj.saveEmployee(emp);
    }



}
