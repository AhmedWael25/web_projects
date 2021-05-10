package com.playground.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.playground.models.Customer;
import com.playground.services.CustomerService;

import com.playground.utils.ServiceError;
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
    public String getAllCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        Gson gson = new Gson();
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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceError> handleError(RuntimeException ex){
        ServiceError err = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
        return  new ResponseEntity<>(err, HttpStatus.OK);
    }

//    @Autowired
//    // REMEMBER: When aurowiring fails(it found multiple types for the samme bean)
//    //it will TRY and find by name, and thee name it will search for is name of the member var provided
//    //If no name that matches the var name is found then it THROWS AN ERR.
//    @Qualifier(value = "userService1")
//    private UserService userService;
//
//    @Autowired
//    // The 2 instances of UserService where put here as expected.
//    private List<UserService> userServices;
//
//    public UserController(){
//        System.out.println("===User Controller has been Created===");
//    }
//
//
//    // @RequestMapping(method = RequestMethod.GET) //Best practice to determing the HTTP Method
//    // We can have the URL mappping on a method
//    // @RequestMapping("/users.htm")
//    //Alternatively we can use @GetMapping which takes @RequestMapping(method = RequestMethod.GET), as Meta Annotation
//    //We can have mix of the,mm, bec. These shortcuts are on methdos only still
//    // While @RequestMapping is used on classed to have shared mapping
//    @GetMapping
//    public String viewAllUsers1(Model model){
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        System.out.println("To Test User service injectd to Me");
//        System.out.println(userServices.size());
//        System.out.println("I Got Service with hashcode of = "+ userService.hashCode());
//
//        return "usersTable";
//    }
//
//    @GetMapping(value = "/allusers.htm")
//    public String viewAllUsers2(Model model){
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "usersTable";
//    }
//
//    //Here we defined a request param
//    //And to anrrow the request  matching down we checking ofor esixting of a
//    //certain param, We can can also explicitly match for a specific Param
//    // @GetMapping(value ="/user.htm", params = "userId=2")
//    //--
//    //Matching can also be done on Request Headers., same as params
//    // @GetMapping(value ="/user.htm", headers = "userId")
//    @GetMapping(value ="/user.htm", params = "userId")
//    public String viewUser1(@RequestParam(name ="userId", defaultValue = "1")int id,Model model){
//        System.out.println("In ViewUser1 where matched to have a param");
//        System.out.println("Request Param is : "+ id);
//        List<User> users = userService.getRandomUser();
//        model.addAttribute("users", users);
//        return "usersTable";
//    }
//    @GetMapping(value ="/user.htm", params = "!userId")
//    public String viewUser2(@RequestParam(name ="userId", defaultValue = "1")int id,Model model){
//        System.out.println("In ViewUser2 where matched to  NOT HAVE a param");
//        System.out.println("Request Param is : "+ id);
//        List<User> users = userService.getRandomUser();
//        model.addAttribute("users", users);
//        return "usersTable";
//    }
//
//    @GetMapping(value = "/{userId}.htm")
//    public String viewUser3(@PathVariable(name ="userId")int id,Model model){
//        System.out.println("In ViewUser3 where We Used URL Template Patterns");
//        System.out.println("PathVariable  is : "+ id);
//        List<User> users = userService.getRandomUser();
//        model.addAttribute("users", users);
//        return "usersTable";
//    }
//
//    @GetMapping(value = "/userJson.htm")
//    @ResponseBody //With this Anno. retutn is palce direclt on response body
//    //and not palce on Model or being interpreted as view name
//    public String viewUser4(Model model){
//        System.out.println("In ViewUser4 where We Return user json as response body");
//        List<User> users = userService.getRandomUser();
//
//        Gson gson = new Gson();
//        return gson.toJson(users) ;
//    }
//
//    @ResponseBody
//    @GetMapping(value="/cookie.htm")
//    public String displayCookie(@CookieValue("JSESSIONID")String cookie){
//        return cookie;
//    }
//
//    @ResponseBody
//    @GetMapping(value="/headers.htm")
//    public String displayHeaders(@RequestHeader("User-Agent") String keepAlive , @RequestHeader("Accept")String accept){
//        return accept + " /n " + keepAlive;
//    }


}
