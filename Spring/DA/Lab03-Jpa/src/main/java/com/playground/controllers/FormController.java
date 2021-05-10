package com.playground.controllers;

import com.playground.domain.Customer;

import com.playground.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class FormController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String createNewUser(Model model){
        model.addAttribute(new Customer());
        return "formView";
    }


//    @PostMapping
//    //To validate insert the @Valid annotation, we should also add the BindingResult arg.
//    //Ordering matters it should follow what we annotated with @Valid
//    public  String registerUser(@Valid @ModelAttribute("user") Customer customer, BindingResult result, Model model){
//
//        if(result.hasErrors()){
//            model.addAttribute(customer);
//            return "formView";
//        }else {
//            userService.addUser(customer);
//            return "redirect:/users.htm";
//        }
//
//    }

}
