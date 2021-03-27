package org.playground.domain;// default package
// Generated Mar 20, 2021, 1:29:54 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Seller generated by hbm2java
 */
@Entity
@Table(name="seller"
    ,catalog="biddingschema"
)
public class Seller  implements java.io.Serializable {


     private int id;
     private User user;
     private String value;
     private Set<Product> products = new HashSet<Product>(0);

    public Seller() {
    }

	
    public Seller(User user, String value) {
        this.user = user;
        this.value = value;
    }
    public Seller(User user, String value, Set<Product> products) {
       this.user = user;
       this.value = value;
       this.products = products;
    }
   
     @GenericGenerator(name="SellerIdGenerator", strategy="foreign", parameters=@Parameter(name="property", value="user"))@Id @GeneratedValue(generator="SellerIdGenerator")

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="value", nullable=false, length=100)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="seller")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", user=" + user +
                ", value='" + value + '\'' +
                '}';
    }
}


