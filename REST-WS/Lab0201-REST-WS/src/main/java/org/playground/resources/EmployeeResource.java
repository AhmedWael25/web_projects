package org.playground.resources;

import org.playground.dao.impl.EmployeeImpl;
import org.playground.dao.interfaces.EmployeeDao;
import org.playground.domain.Employee;

import org.playground.resources.exceptions.*;
import org.playground.resources.models.EmpDto;
import org.playground.resources.models.MyLink;
import org.playground.util.EntityToDtoMapper;

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

import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Context;

import org.playground.util.*;


@Path("emps")
@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
public class EmployeeResource {


    private static  EmployeeDao empDao = EmployeeImpl.getInstance();

    @GET
    public Response getAllEmployees(){
        
        List<Employee> empList  = empDao.getAll();

         return Response.ok().entity(empList).build();
    }

    @GET
    @Path("{id}")
    public Response getEmpById(@PathParam("id") int id , @Context UriInfo uriInfo){


        Employee emp =  empDao.getEmployeeById(id);

        if(emp == null){
            throw new EmpNotFoundException("No Such Employee With ID : "+ id);
        }


        EntityToDtoMapper<EmpDto, Employee> mapper = new DBEmpToEmpDto();
        
        EmpDto  requestedEmp = mapper.convertEntityToDto(emp);

        //HATEOAS PART
        
        MyLink mLink = new MyLink();
        mLink.setRel("MYLINK");
        mLink.setUri(uriInfo.getAbsolutePathBuilder().toString());

        requestedEmp.setLinks(Arrays.asList(mLink));

        return Response.ok().entity(requestedEmp).header("Test", "TESTED HEADER").build();
    }

    @POST
    public Employee createNewEmp(Employee emp){
        return empDao.saveEmployee(emp);
    }

    @PUT
    // @Path("{id}") @PathParam("id") int id,
    public Response updateEmployee( Employee emp){
        
        int empId = emp.getId();

        boolean isExist = empDao.isEmployeeExists(empId);

        if(!isExist)
            throw new EmpNotFoundException("No Such Employee With ID : "+ empId);

        Employee updatedEmp =  empDao.updateEmployee(emp);
            
        return Response.accepted().entity(updatedEmp).build();
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
