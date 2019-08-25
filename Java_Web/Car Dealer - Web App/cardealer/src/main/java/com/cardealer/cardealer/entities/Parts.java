package com.cardealer.cardealer.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "part_id")
    private long partId;
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
    @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
    private List<CarParts> carsParts;
    public Parts() {
    }




    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
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
