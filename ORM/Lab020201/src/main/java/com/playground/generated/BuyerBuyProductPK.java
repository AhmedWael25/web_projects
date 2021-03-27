package com.playground.generated;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BuyerBuyProductPK implements Serializable {
    private int buyerId;
    private int productId;

    @Column(name = "buyer_id")
    @Id
    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "product_id")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerBuyProductPK that = (BuyerBuyProductPK) o;
        return buyerId == that.buyerId && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerId, productId);
    }
}
