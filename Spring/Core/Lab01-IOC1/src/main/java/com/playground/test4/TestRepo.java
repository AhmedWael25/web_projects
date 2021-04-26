package com.playground.test4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

@Setter @Getter @ToString
public class TestRepo {

    @Value("Def Value From Anno.")
    private String name;

    @Value("66")
    private int age;

    //On-demand access, if Child doesnot exist on access => error
    private Provider<ChildRepo> child;

    public TestRepo(){
        System.out.println("TestRepo Bean: TestRepo()");
    }

    @Inject
    public TestRepo(Provider<ChildRepo> c){
        System.out.println("TestRepo Bean: TestRepo(Provider<Child> c)");
        this.child = c;
    }




    public ChildRepo getMyChild(){
        return  child.get();
    }

    @PostConstruct
    public void init(){
        System.out.println("TestRepo Init()");
    }
    @PreDestroy
    public  void close(){
        System.out.println("TestRepo close()");
    }

}