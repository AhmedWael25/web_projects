package com.playground.repositories.rowmappers;

import com.playground.models.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerResultSetExtractor implements ResultSetExtractor<List<Customer>> {
    @Override
    public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Customer> customers = new ArrayList<>();

        while( rs.next() ){
            Customer c = new Customer();
            c.setId( rs.getInt("id") );
            c.setFirstName( rs.getString("firstName") );
            c.setLastName( rs.getString("lastName") );
            c.setSalary( rs.getInt("salary") );

            customers.add(c);
        }
        return customers;
    }
}
