package com.playground.controllers;

import com.playground.domains.Customer;
import com.playground.services.impls.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers") //Anno used ot map URL patterns
public class CustomerController {

    private  CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<Customer> getAllCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();

        return new ResponseEntity(customers, HttpStatus.OK);
    }
    @GetMapping("/count")
    public String getCustomersCount(Model model){

        return customerService.getCount()+"";
    }

    @GetMapping("/{customerId}")
    @ResponseBody
    public  Customer getCustomerById(@PathVariable("customerId")int customerId, Model model){

        Customer customer =  customerService.getCustomer(customerId);
        return customer;
    }

    @PostMapping
    public  Customer createCustomer(@RequestBody Customer customer){
        Customer c = customerService.createCustomer(customer);
        return c;
    }

    @PutMapping
    public  Customer updateCustomer(@RequestBody Customer customer){
        Customer c = customerService.updateCustomer(customer);
        return c;
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId, Model model){
        customerService.removeCustomer(customerId);
        return "redirect:/customers";
    }

}
