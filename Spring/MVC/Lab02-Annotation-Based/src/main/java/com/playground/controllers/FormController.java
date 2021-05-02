package com.playground.controllers;

import com.playground.models.User;

import com.playground.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register.htm")
public class FormController {

    @Autowired
    private UserService userService;
    

    @GetMapping
    public String createNewUser(Model model){
        model.addAttribute(new User());
        return "formView";
    }


    @PostMapping
    //To validate insert the @Valid annotation, we should also add the BindingResult arg.
    //Ordering matters it should follow what we annotated with @Valid
    public  String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute(user);
            return "formView";
        }else {
            userService.addUser(user);
            return "redirect:/users.htm";
        }

    }

}
