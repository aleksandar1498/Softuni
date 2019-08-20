package com.cardealer.cardealer.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "car_id")
    private long carId;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "travelled_distance")
    private long travelledDistance;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<CarParts> carsParts;

    public Car() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
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
        return this.getCarId() + " " + this.getMake();
    }
}
