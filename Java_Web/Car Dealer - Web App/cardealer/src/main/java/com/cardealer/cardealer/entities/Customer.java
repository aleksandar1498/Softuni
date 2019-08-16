package com.cardealer.cardealer.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private BigInteger id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date birthDate;
    @Column(name = "is_young_driver")
    private int isYoungDriver;


    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(int isYoungDriver) {
        this.isYoungDriver = isYoungDriver;
    }

    @Override
    public String toString() {
        return this.getName()+" "+this.getBirthDate().toString();
    }
}
