package com.playground.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.playground.domain.Customer;
import com.playground.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users") //Anno used ot map URL patterns
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    @ResponseBody
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        Gson gson = new Gson();
        return gson.toJson(customers);
    }


    @GetMapping(params = {"page", "count"})
    @ResponseBody
    public String getAllCustomersPaged(@RequestParam("page")int page, @RequestParam("count")int count,Model model){
        Gson gson = new Gson();
        List<Customer> customers = customerService.getAllCustomersPaged(page, count);
        return gson.toJson(customers);
    }

    @GetMapping("/count")
    @ResponseBody
    public String getCustomersCount(Model model){
        Gson gson = new Gson();
        return gson.toJson(customerService.getCount());
    }

    @GetMapping("/{customerId}")
    @ResponseBody
    public  String getCustomerById(@PathVariable("customerId")int customerId, Model model){
        Customer customer =  customerService.getCustomer(customerId);
        Gson gson = new Gson();
        if(customer != null){
            return gson.toJson(customer);
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
