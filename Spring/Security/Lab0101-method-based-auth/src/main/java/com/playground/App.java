package com.playground;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.Scanner;

public class App {
    
    
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("security-configs.xml");

        Scanner scanner = new Scanner(System.in);

        System.out.println("User Name: ");
        String userName = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        scanner.close();


        try{

            Authentication authToken = new UsernamePasswordAuthenticationToken(userName,password);
            AuthenticationManager authManager = ctxt.getBean(AuthenticationManager.class);
            Authentication authedToken = authManager.authenticate(authToken);

            //In a non-container managed env. , we are supposed to handle the security context
            SecurityContext securityContext = new SecurityContextImpl();
            securityContext.setAuthentication(authedToken);
            SecurityContextHolder.setContext(securityContext);

            HelloService helloService = ctxt.getBean("helloService", HelloService.class);

            // ALL ACCESS
           System.out.println(helloService.allAccess());
           //USER Access
           System.out.println(helloService.userAccess());
           //ADMIN Access
           System.out.println(helloService.adminAccess());

           //All has denied Access
           System.out.println(helloService.denyAllAccess());

            //=============================================
            //Pre And Post filter/authorization
            // System.out.println(helloService.addStringAdminOnly("New"));  //Gives an ERROR bec. length restriction we put
            // System.out.println(helloService.addStringAdminOnly("admin"));

            // System.out.println(helloService.returnString());

            // System.out.println(helloService.getAllStrings());



        }catch (BadCredentialsException e){
            System.out.println("Wrong Credentials");
        }catch (AccessDeniedException e){
            System.out.println("Not Authorized");
        }

        ctxt.close();
    }

}