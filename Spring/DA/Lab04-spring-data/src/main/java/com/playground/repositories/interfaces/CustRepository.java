package com.playground.repositories.interfaces;

import com.playground.domain.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Min;
import java.util.List;

public interface CustRepository extends PagingAndSortingRepository<Customer, Integer> {

    //Modify for update,insert,del
    //we can define insert our own Queries
//    @Modifying
//    @Query("update Customer c set c.firstName=?1, c.lastName = ?2 , c.salary=?3 WHERE c.id=?4")
//    void updateCustomer( String firstName,
//                         String lastName,
//                         Double salary, Integer id);


    List<Customer> findBySalaryGreaterThanEqualOrderBySalaryDesc(double salary);



}
