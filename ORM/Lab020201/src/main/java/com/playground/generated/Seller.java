package com.playground.generated;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Seller {
    private int id;
    private String value;
    private Collection<Product> productsById;
    private User userById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return id == seller.id && Objects.equals(value, seller.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @OneToMany(mappedBy = "sellerBySellerId")
    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public User getUserById() {
        return userById;
    }

    public void setUserById(User userById) {
        this.userById = userById;
    }
}
