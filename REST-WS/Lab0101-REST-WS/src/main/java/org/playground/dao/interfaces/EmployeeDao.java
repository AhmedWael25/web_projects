package org.playground.dao.interfaces;

import org.playground.domain.*;
import java.util.*;


public interface EmployeeDao{

    Employee saveEmployee(Employee emp);

    Employee getEmployeeById(Integer Id);

    void deleteEmployeeById(Integer id);

    Employee updateEmployee(Employee emp);

    List<Employee> getAll();

    void deleteAllEmps();

    boolean isEmployeeExists(int id);

    List<Employee> getAllPaginated(int start, int offset);    

}
