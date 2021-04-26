package org.playground.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
@Table(name = "users", catalog = "ormdb", schema = "ormdb")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name="fname")
    private String firstName;

    @Column(name="lname")
    private String secondName;

    @Column(name="job")
    private String job;

    @Temporal(TemporalType.DATE)
    @Column(name="dob")
    private Date dob;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", job='" + job + '\'' +
                ", dob=" + dob +
                '}';
    }
}
