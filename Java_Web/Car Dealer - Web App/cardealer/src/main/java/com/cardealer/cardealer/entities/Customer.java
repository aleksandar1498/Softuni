package com.cardealer.cardealer.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;
    @Column(name = "birth_date")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date birthDate;
    @Column(name = "is_young_driver")
    private int isYoungDriver;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Sales> sales;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
