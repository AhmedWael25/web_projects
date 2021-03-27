package com.playground.generated;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Buyer {
    private int id;
    private String value;
    private int userId;
    private User userByUserId;
    private Collection<BuyerBidProduct> buyerBidProductsById;
    private Collection<BuyerBuyProduct> buyerBuyProductsById;

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

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return id == buyer.id && userId == buyer.userId && Objects.equals(value, buyer.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, userId);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "buyerByBuyerId")
    public Collection<BuyerBidProduct> getBuyerBidProductsById() {
        return buyerBidProductsById;
    }

    public void setBuyerBidProductsById(Collection<BuyerBidProduct> buyerBidProductsById) {
        this.buyerBidProductsById = buyerBidProductsById;
    }

    @OneToMany(mappedBy = "buyerByBuyerId")
    public Collection<BuyerBuyProduct> getBuyerBuyProductsById() {
        return buyerBuyProductsById;
    }

    public void setBuyerBuyProductsById(Collection<BuyerBuyProduct> buyerBuyProductsById) {
        this.buyerBuyProductsById = buyerBuyProductsById;
    }
}
