package com.playground.controllers;

import com.playground.domains.Customer;
import com.playground.services.impls.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users") //Anno used ot map URL patterns
public class CustomerController {

    private  CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }



    @GetMapping
    @ResponseBody
    public String getAllCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        return  customers.toString();
    }
    @GetMapping("/count")
    @ResponseBody
    public String getCustomersCount(Model model){

        return customerService.getCount()+"";
    }

    @GetMapping("/{customerId}")
    @ResponseBody
    public  String getCustomerById(@PathVariable("customerId")int customerId, Model model){
        Customer customer =  customerService.getCustomer(customerId);
        if(customer != null){
            return customer.toString();
        }else {
            return "No Customer Found";
        }
    }

    @PostMapping
    public  String createCustomer(@RequestBody Customer customer){
        Customer c = customerService.createCustomer(customer);
        System.out.println(c);
        return "redirect:/users";
    }

    @PutMapping
    public  String updateCustomer(@RequestBody Customer customer){
        Customer c = customerService.updateCustomer(customer);
        return "redirect:/users";
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId, Model model){
        customerService.removeCustomer(customerId);
        return "redirect:/users";
    }

}
