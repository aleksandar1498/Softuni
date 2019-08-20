package com.cardealer.cardealer.entities;

import javax.persistence.*;

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "car_id")
    private long carId;

    @ManyToOne
    @JoinColumn(name = "car_id",insertable = false,updatable = false)
    private Car car;

    @Column(name = "customer_id")
    private long customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable = false,updatable = false)
    private Customer customer;

}
