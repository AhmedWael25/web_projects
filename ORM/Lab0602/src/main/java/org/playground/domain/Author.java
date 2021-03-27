package org.playground.domain;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity(name = "author")
@Table(name = "author", catalog = "webservicedb" , schema = "webservicedb")
public class Author {

    public Author() {

    }

    public Author(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "age")
    @Min(value = 20, message = "Age should not be less than 20")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
