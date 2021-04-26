package com.playground.test3;



import com.playground.test4.ParentRepo;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.*;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.Arrays;


public class Try3{

    public static void main(String[] args) throws IOException {
        
        System.out.println("HELLO Try 3");

        ConfigurableApplicationContext factory = new ClassPathXmlApplicationContext("beans7.xml");

        ParentRepo p = (ParentRepo)factory.getBean("parent1");
        System.out.println(p);

        // Trigger request on Child, which is lazily loaded
        // Child init on request and is printed
        //when removed, Child not printed
    //    System.out.println(p.getMyChild());


        factory.registerShutdownHook();

        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");

//        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig1.class);
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.playground.test3");
//        appContext.register(Parent.class); //This used with the constructor that takes AppConfig 1 which
        // scanned the Parent class, triggered a shutdown life-cycle, why?
        /* print =>
        Parent Bean: Parent(Provider<Child> c)
        Parent Init()
        Parent close()
        */
        appContext.register(AppConfig1.class);
        appContext.register(AppConfig4.class);
        appContext.register(AppConfig5.class);
        appContext.getEnvironment().setActiveProfiles("production");
        appContext.refresh();
        //When ComponentScan was enabled in Appconfig1 class, it was able to pick up the Parent component
        ///When using proramatic approach scn/  register  make sure to refresh at the end
        //If we used constructor n with refresh will give exception that refresh was used multiple times

        System.out.println("-----");
        Environment env = appContext.getEnvironment();

        System.out.println(Arrays.toString(env.getActiveProfiles()));
        System.out.println("my Java Home : " + env.getProperty("JAVA_HOME"));
        appContext.registerShutdownHook();

        System.in.read();


        factory.close();
        appContext.close();
    }
}