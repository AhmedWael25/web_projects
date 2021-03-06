package com.playground.dao;// default package
// Generated Mar 20, 2021, 1:49:38 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.Date;

/**
 * BuyerBuyProduct generated by hbm2java
 */

public class BuyerBuyProduct  implements java.io.Serializable {


     private BuyerBuyProductId id;
     private Buyer buyer;
     private Product product;
     private Date paymentDate;
     private float amount;
     private int quantity;

    public BuyerBuyProduct() {
    }

    public BuyerBuyProduct(BuyerBuyProductId id, Buyer buyer, Product product, Date paymentDate, float amount, int quantity) {
       this.id = id;
       this.buyer = buyer;
       this.product = product;
       this.paymentDate = paymentDate;
       this.amount = amount;
       this.quantity = quantity;
    }
   

    public BuyerBuyProductId getId() {
        return this.id;
    }
    
    public void setId(BuyerBuyProductId id) {
        this.id = id;
    }


    public Buyer getBuyer() {
        return this.buyer;
    }
    
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }


    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    

    public float getAmount() {
        return this.amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }

    

    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


