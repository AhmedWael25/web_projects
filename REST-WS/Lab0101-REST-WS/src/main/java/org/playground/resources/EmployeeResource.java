package org.playground.resources;

import org.playground.dao.impl.EmployeeImpl;
import org.playground.dao.interfaces.EmployeeDao;
import org.playground.domain.Employee;

import java.util.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("emps")
@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
public class EmployeeResource {


    private static  EmployeeDao empDao = EmployeeImpl.getInstance();

    @GET
    public List<Employee> getAllEmployees(){
        return empDao.getAll();
    }

    @GET
    @Path("{id}")
    public Employee getEmpById(@PathParam("id") int id){
        return empDao.getEmployeeById(id);
    }

    @POST
    public Employee createNewEmp(Employee emp){
        return empDao.saveEmployee(emp);
    }

    @PUT
    // @Path("{id}") @PathParam("id") int id,
    public Employee updateEmployee( Employee emp){
        
        int empId = emp.getId();

        boolean isExist = empDao.isEmployeeExists(empId);

        if(!isExist)
            throw new IllegalArgumentException("EMPLOYEE DOESNOT EXIST LOL xD");


        return empDao.updateEmployee(emp);
    }

    
    @DELETE
    @Path("{id}")
    public void deleteEmployeeById(@DefaultValue("5") @PathParam("id") int id){
        empDao.deleteEmployeeById(id);
    }


    @GET
    @Path("/paging")
    public List<Employee> fetchPaginated(@DefaultValue("0") @QueryParam("start") int start, @QueryParam("offset") int offset){
        return empDao.getAllPaginated(start, offset);
    }


}
