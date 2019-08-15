package com.cardealer.cardealer.models;

import java.math.BigInteger;
import java.util.Date;

public class CustomerBindingModel {

    private BigInteger id;

    private String name;

    private java.util.Date birthDate;
    private int isYoungDriver;

    public CustomerBindingModel() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
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
}
