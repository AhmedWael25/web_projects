package com.playground.repositories;


import com.playground.models.Customer;
import com.playground.repositories.rowmappers.CustomerResultSetExtractor;
import com.playground.repositories.rowmappers.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("customerRepository")
public class CustomerRepositoryImpl  implements CustomerRepository{

    private JdbcTemplate jdbcTemplate;
    private  NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        System.out.println(">> CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) : Created");
        this.jdbcTemplate = jdbcTemplate;
        this.namedJdbcTemplate = namedParameterJdbcTemplate;

        System.out.println("//============================ repo is up ...TESTING IT'S MTHODS =====================");
        Customer customer = new Customer();
        customer.setFirstName("NEWsdsd");
        customer.setLastName("N22");
        customer.setSalary(2313);

        System.out.println(getCustomerById(6));
        getAllCustomers3();

    }
    //Using our own impl. of RowMapper
    public List<Customer> getAllCustomers(){
        String sql = "SELECT * from customers";
        Map<String, Object>  args = new HashMap<>();
        List<Customer> customers = jdbcTemplate.query(sql, new CustomerRowMapper());
        return customers;
    }
    //Using our own Impl. of ResultSetExtractor
    public List<Customer> getAllCustomers2(){
        String sql = "SELECT * from customers";
        Map<String, Object>  args = new HashMap<>();
        List<Customer> customers = jdbcTemplate.query(sql, new CustomerResultSetExtractor());
        return customers;
    }

    public  void getAllCustomers3(){
        String sql = "SELECT * from customers WHERE id = :id";

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getAllCustomers");
        var out = simpleJdbcCall.execute(simpleJdbcCall);
        System.out.println(out);
    }

    public  Customer getCustomerById(int id){
        String sql = "SELECT * from customers WHERE id = :id";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", id);
//        Customer c = namedJdbcTemplate.queryForObject(sql, paramSource, new BeanPropertyRowMapper<>(Customer.class));
        Customer c = null;
        try{
            c = namedJdbcTemplate.queryForObject(sql, paramSource, new CustomerRowMapper());
        }catch (EmptyResultDataAccessException e){
         c = null;
        }

        return c;
    }




    public int getCount(){

        String sql= "SELECT count(*) FROM customers";
        int rowCount = jdbcTemplate.queryForObject(sql,Integer.class);
        return rowCount;
    }

    public int getCountGreaterThan(int salary){
        String sql= "SELECT count(*) FROM customers WHERE salary >= ?";
        //This is deprecated so we shouyld use varargs instead
        //int rowCount = jdbcTemplate.queryForObject(sql, new Object[]{salary}, Integer.class);
        int rowCount2 = jdbcTemplate.queryForObject(sql, Integer.class, salary);
        return rowCount2;
    }

    public int updateCustomer(Customer customer){
        //String sql = "UPDATE customer set firstName=?, lastName=?, sallary=? WHERE id=?";
        //Instead we can use named parameter jdbc tempalte to be more descriptive
        //int rowCount= jdbcTemplate.update(sql,customer.getFirstName(), customer.getLastName(), customer.getSalary(), customer.getId());

        String sql = "UPDATE customers set firstName = :firstName, lastName= :lastName, salary= :salary WHERE id = :id ";

        Map<String, Object> args = new HashMap<>();
        args.put("firstName", customer.getFirstName());
        args.put("lastName", customer.getLastName());
        args.put("salary", customer.getSalary());
        args.put("id", customer.getId());

        int rowCount = namedJdbcTemplate.update(sql,args);

        return  rowCount;
    }

    public int deleteCustomer(int id){
        String sql = "DELETE FROM customers WHERE id=?";
        int rowCount = jdbcTemplate.update(sql, id);
        return rowCount;
    }

    public int insertCustomer(Customer customer){
        String sql = "INSERT INTO customers(firstName, lastName, salary) VALUES(:firstName, :lastName, :salary)";
        Map<String, Object> args = new HashMap<>();
        args.put("firstName", customer.getFirstName());
        args.put("lastName", customer.getLastName());
        args.put("salary", customer.getSalary());
        int rowCount = namedJdbcTemplate.update(sql, args);
        return  rowCount;
    }

    public Customer insertCustomer2(Customer customer){

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        simpleJdbcInsert.withTableName("customers")
                .usingColumns("firstName", "lastName", "salary")
                .usingGeneratedKeyColumns("id");

        //We Can either use a Map of col_name and value
        //or we can use BeanPropertySqlParameterSource which implements
        //T.C with it Class used need to he its member vars of same name as table
        //SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);

        //Or use MapSql.. which is basically a map.
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("firstName", customer.getFirstName())
                .addValue("lastName", customer.getLastName())
                .addValue("salary", customer.getSalary());


        int keyValue = simpleJdbcInsert.executeAndReturnKey(parameterSource).intValue();

        customer.setId(keyValue);

        return  customer;
    }


}
