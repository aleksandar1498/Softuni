package com.cardealer.cardealer.entities;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Parts {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "supplier_id")
    private long supplierId;
    @ManyToOne
    @JoinColumn(name = "supplier_id",insertable = false,updatable = false)
    private Supplier supplier;
    @ManyToMany(mappedBy = "parts")
    Set<Car> cars;
    public Parts() {
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
