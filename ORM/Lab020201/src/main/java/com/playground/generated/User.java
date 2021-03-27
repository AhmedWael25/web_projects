package com.playground.generated;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String email;
    private String address;
    private String phone;
    private String mobile;
    private Date dateOfBirth;
    private Date registrationDate;
    private String userName;
    private String password;
    private String fullName;
    private Collection<Buyer> buyersById;
    private Seller sellerById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "registration_date")
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(phone, user.phone) && Objects.equals(mobile, user.mobile) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(registrationDate, user.registrationDate) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(fullName, user.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, address, phone, mobile, dateOfBirth, registrationDate, userName, password, fullName);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Buyer> getBuyersById() {
        return buyersById;
    }

    public void setBuyersById(Collection<Buyer> buyersById) {
        this.buyersById = buyersById;
    }

    @OneToOne(mappedBy = "userById")
    public Seller getSellerById() {
        return sellerById;
    }

    public void setSellerById(Seller sellerById) {
        this.sellerById = sellerById;
    }
}
