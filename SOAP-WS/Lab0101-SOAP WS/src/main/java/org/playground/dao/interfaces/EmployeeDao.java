package org.playground.dao.interfaces;

import org.playground.domain.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;



@WebService
public interface EmployeeDao{

    @WebMethod
    Employee saveEmployee(Employee emp);

    @WebMethod
    Employee getEmployeeById(Integer Id);

    @WebMethod
    void deleteEmployeeById(Integer id);

    @WebMethod
    Employee updateEmployee(Employee emp);

    
    
}
