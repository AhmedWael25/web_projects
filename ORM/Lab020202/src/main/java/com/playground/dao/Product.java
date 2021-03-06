package com.playground.dao;// default package
// Generated Mar 20, 2021, 1:49:38 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */

public class Product  implements java.io.Serializable {


     private Integer id;
     private Seller seller;
     private String name;
     private String description;
     private String manufacturingName;
     private Date manufacturingDate;
     private Date expirationDate;
     private int quantity;
     private Date offeredDate;
     private Date finishDate;
     private Set<Category> categories = new HashSet<Category>(0);
     private Set<BuyerBidProduct> buyerBidProducts = new HashSet<BuyerBidProduct>(0);
     private Set<BuyerBuyProduct> buyerBuyProducts = new HashSet<BuyerBuyProduct>(0);

    public Product() {
    }

	
    public Product(String name, String manufacturingName, Date manufacturingDate, int quantity, Date offeredDate, Date finishDate) {
        this.name = name;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.quantity = quantity;
        this.offeredDate = offeredDate;
        this.finishDate = finishDate;
    }
    public Product(String description,Seller seller,String name, String manufacturingName, Date manufacturingDate, int quantity, Date offeredDate, Date finishDate,Date expired) {
        this.seller=seller;
        this.description=description;
        this.name = name;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.quantity = quantity;
        this.offeredDate = offeredDate;
        this.finishDate = finishDate;
        this.expirationDate = expired;
    }
    public Product(Seller seller, String name, String description, String manufacturingName, Date manufacturingDate, Date expirationDate, int quantity, Date offeredDate, Date finishDate, Set<Category> categories, Set<BuyerBidProduct> buyerBidProducts, Set<BuyerBuyProduct> buyerBuyProducts) {
       this.seller = seller;
       this.name = name;
       this.description = description;
       this.manufacturingName = manufacturingName;
       this.manufacturingDate = manufacturingDate;
       this.expirationDate = expirationDate;
       this.quantity = quantity;
       this.offeredDate = offeredDate;
       this.finishDate = finishDate;
       this.categories = categories;
       this.buyerBidProducts = buyerBidProducts;
       this.buyerBuyProducts = buyerBuyProducts;
    }
   


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }



    public Seller getSeller() {
        return this.seller;
    }
    
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

        public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    

    public String getManufacturingName() {
        return this.manufacturingName;
    }
    
    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }


    public Date getManufacturingDate() {
        return this.manufacturingDate;
    }
    
    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }


    public Date getExpirationDate() {
        return this.expirationDate;
    }
    
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    

    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOfferedDate() {
        return this.offeredDate;
    }
    
    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }


    public Date getFinishDate() {
        return this.finishDate;
    }
    
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    public Set<BuyerBidProduct> getBuyerBidProducts() {
        return this.buyerBidProducts;
    }
    
    public void setBuyerBidProducts(Set<BuyerBidProduct> buyerBidProducts) {
        this.buyerBidProducts = buyerBidProducts;
    }


    public Set<BuyerBuyProduct> getBuyerBuyProducts() {
        return this.buyerBuyProducts;
    }
    
    public void setBuyerBuyProducts(Set<BuyerBuyProduct> buyerBuyProducts) {
        this.buyerBuyProducts = buyerBuyProducts;
    }




}


