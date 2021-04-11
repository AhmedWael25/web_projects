package org.playground.dao.impl;

import org.playground.dao.interfaces.EmployeeDao;

import org.playground.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Date;

import jakarta.jws.WebService;


@WebService(endpointInterface = "org.playground.dao.interfaces.EmployeeDao")
public class EmployeeImpl  implements EmployeeDao{
   

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice_JPA");
    EntityManager em = emf.createEntityManager();

    @Override
    public Employee saveEmployee(Employee emp){

        em.getTransaction().begin();

        em.persist(emp);

        em.getTransaction().commit();
        
        return emp;
    }

    @Override
    public Employee getEmployeeById(Integer id){


        if(id < 0){
            throw new IllegalArgumentException("Id cannot be -ve");
        }

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

}
