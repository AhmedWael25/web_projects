package com.playground.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name ="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @ManyToMany(mappedBy = "orders")
    @JsonIgnore
    private Set<Product> products;


}
