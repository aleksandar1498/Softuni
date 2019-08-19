package com.cardealer.cardealer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    private long id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "travelled_distance")
    private long travelledDistance;
    @ManyToMany
            @JoinTable(name = "parts_cars",
            joinColumns= @JoinColumn(name="car_id"),
    inverseJoinColumns = @JoinColumn(name = "part_id"))
    Set<Parts> parts;
    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getMake();
    }
}
