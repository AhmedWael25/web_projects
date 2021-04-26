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
import javax.inject.Singleton;

@Setter @Getter @ToString
//@Component
@Named("parent1")
@Scope("singleton")
//@Singleton
public class ParentRepo {

    @Value("Def Value From Anno.")
    private String name;

    @Value("66")
    private int age;

    //On-demand access, if Child doesnot exist on access => error
    private Provider<ChildRepo> child;

    public ParentRepo(){
        System.out.println("Parent Bean: Parent()");
    }

    @Inject
    //Also Optional and @Nullabkle can be used for non-optional Dependencies
    //Difference betweenn inject and autowired, is that the latter has an required attribute
    public ParentRepo(Provider<ChildRepo> c){
        System.out.println("Parent Bean: Parent(Provider<Child> c)");
        this.child = c;
    }


//    @Inject
//    public Parent(Child child){
//        System.out.println("Parent : Parent(Child child)");
//    }
//    @Inject
//    public void setChild(Child c){
//
//    }

    public ChildRepo getMyChild(){
        return  child.get();
    }

    @PostConstruct
    public void init(){
        System.out.println("Parent Init()");
    }
    @PreDestroy
    public  void close(){
        System.out.println("Parent close()");
    }

}