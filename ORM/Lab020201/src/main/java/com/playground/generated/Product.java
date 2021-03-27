package com.playground.generated;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Product {
    private int id;
    private String name;
    private String description;
    private String manufacturingName;
    private Date manufacturingDate;
    private Date expirationDate;
    private Integer sellerId;
    private int quantity;
    private Date offeredDate;
    private Date finishDate;
    private Collection<BuyerBidProduct> buyerBidProductsById;
    private Collection<BuyerBuyProduct> buyerBuyProductsById;
    private Seller sellerBySellerId;
    private Collection<ProductHasCategory> productHasCategoriesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "manufacturing_name")
    public String getManufacturingName() {
        return manufacturingName;
    }

    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }

    @Basic
    @Column(name = "manufacturing_date")
    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Basic
    @Column(name = "expiration_date")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "seller_id")
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "offered_date")
    public Date getOfferedDate() {
        return offeredDate;
    }

    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }

    @Basic
    @Column(name = "finish_date")
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(manufacturingName, product.manufacturingName) && Objects.equals(manufacturingDate, product.manufacturingDate) && Objects.equals(expirationDate, product.expirationDate) && Objects.equals(sellerId, product.sellerId) && Objects.equals(offeredDate, product.offeredDate) && Objects.equals(finishDate, product.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, manufacturingName, manufacturingDate, expirationDate, sellerId, quantity, offeredDate, finishDate);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<BuyerBidProduct> getBuyerBidProductsById() {
        return buyerBidProductsById;
    }

    public void setBuyerBidProductsById(Collection<BuyerBidProduct> buyerBidProductsById) {
        this.buyerBidProductsById = buyerBidProductsById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<BuyerBuyProduct> getBuyerBuyProductsById() {
        return buyerBuyProductsById;
    }

    public void setBuyerBuyProductsById(Collection<BuyerBuyProduct> buyerBuyProductsById) {
        this.buyerBuyProductsById = buyerBuyProductsById;
    }

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    public Seller getSellerBySellerId() {
        return sellerBySellerId;
    }

    public void setSellerBySellerId(Seller sellerBySellerId) {
        this.sellerBySellerId = sellerBySellerId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ProductHasCategory> getProductHasCategoriesById() {
        return productHasCategoriesById;
    }

    public void setProductHasCategoriesById(Collection<ProductHasCategory> productHasCategoriesById) {
        this.productHasCategoriesById = productHasCategoriesById;
    }
}
