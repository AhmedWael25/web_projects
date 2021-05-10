package com.playground.repositories.rowmappers;

import com.playground.models.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer c = new Customer();
        c.setId( rs.getInt("id") );
        c.setFirstName( rs.getString("firstName") );
        c.setLastName( rs.getString("lastName") );
        c.setSalary( rs.getInt("salary") );
        return c;
    }
}
