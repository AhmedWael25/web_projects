package com.playground.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String getIndexPage(Model model){
        return "welcomePage";
    }

    @GetMapping("/login")
    public  String getLoginPage(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "loginPage2";
        }
        return "redirect:/";
    }

    @GetMapping("/error")
    public  String getErrorPage(Model model){
        return "errorPage";
    }

    @GetMapping("/admin/dashboard")
    public  String getDashboardPage(Model model){
        return "dashboardPage";
    }

    @GetMapping("/profile")
    public  String getProfilePage(Model model){
        return "profilePage";
    }

}
