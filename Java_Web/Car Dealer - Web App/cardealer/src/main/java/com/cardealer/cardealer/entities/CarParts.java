package com.cardealer.cardealer.entities;

import javax.persistence.*;

@Entity
@Table(name = "parts_cars")
public class CarParts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "car_id")
    private long carId;

    @ManyToOne
    @JoinColumn(name = "car_id",insertable = false,updatable = false)
    private Car car;

    @Column(name = "part_id")
    private long partId;

    @ManyToOne
    @JoinColumn(name = "part_id",insertable = false,updatable = false)
    private Parts part;

    public CarParts() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
    }
}
