package com.playground.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "product")
@XmlRootElement
public class Product {

    @Id
    @Column(name ="prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "prod_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = {  @JoinColumn(name = "prod_id") },
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    @JsonIgnore
    private Set<Order> orders;

}
