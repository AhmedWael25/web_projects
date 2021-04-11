package org.playground.dao.impl;

import org.playground.dao.interfaces.EmployeeDao;

import org.playground.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.*;

import jakarta.jws.WebService;


public class EmployeeImpl  implements EmployeeDao{
   
    private static EmployeeImpl employeeImpl = new EmployeeImpl();

    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice_JPA");
    EntityManager em = emf.createEntityManager();


    private EmployeeImpl(){}

    public static EmployeeImpl getInstance(){
        return employeeImpl;
    }

    @Override
    public List<Employee> getAll(){
     
        em.getTransaction().begin();

        Query q = em.createQuery("from employee");
        em.getTransaction().commit();

        List<Employee> empList = q.getResultList();


        return empList;
    }



    @Override
    public Employee saveEmployee(Employee emp){

        em.getTransaction().begin();

        em.persist(emp);

        em.getTransaction().commit();
        
        return emp;
    }

    @Override
    public Employee getEmployeeById(Integer id){


        // if(id < 0){
        //     throw new IllegalArgumentException("Id cannot be -ve");
        // }

        em.getTransaction().begin();


        Employee emp = em.find(Employee.class, id);

        em.refresh(emp);
        em.getTransaction().commit();

        return emp;
    }

    @Override
    public void deleteEmployeeById(Integer id){
        
        em.getTransaction().begin();

        Employee emp = em.find(Employee.class, id);

        em.remove(emp);

        em.getTransaction().commit();

    }
    
    @Override
    public Employee updateEmployee(Employee updatedEmp){
        
        em.getTransaction().begin();

        Employee emp = em.find(Employee.class, updatedEmp.getId());

        emp.setFirstName( updatedEmp.getFirstName() );
        emp.setLastName( updatedEmp.getLastName() );
        emp.setSsn( updatedEmp.getSsn() );

        em.getTransaction().commit();


        return updatedEmp;
    }

    @Override
    public void deleteAllEmps(){
        em.getTransaction().begin();

        Query q = em.createQuery("delete from employees");
        q.executeUpdate();

        em.getTransaction().commit();
    }

    @Override
    public boolean isEmployeeExists(int id){
        em.getTransaction().begin();

        Employee emp = em.find(Employee.class, id);
    
        em.getTransaction().commit();

        if(emp == null){
            return false;
        }else{
            return true;
        }
    
    }

    @Override
    public List<Employee> getAllPaginated(int start, int offset) {
        em.getTransaction().begin();

        Query q = em.createQuery("from employee");
        q.setFirstResult(start);
        q.setMaxResults(offset);

        em.getTransaction().commit();
        
        List<Employee> empList = q.getResultList();

        return empList;

    }



}
