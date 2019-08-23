package com.cardealer.cardealer.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

public class CustomerBindingModel {

    private Long id;
    @NotNull
    @NotEmpty(message = "The name must not be empty")
    @Size(min = 5,max = 10,message = "The name length must be between 5 and 10")
    private String name;

    @DateTimeFormat (pattern="yyyy-MM-dd")
    @NotNull(message = "The date must be set")
    @PastOrPresent(message = "The date must be present or in the past")
    private Date birthDate;
    private int isYoungDriver;

    public CustomerBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }


    public void setBirthDate(Date date){

        this.birthDate = date;
    }

    public int getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(int isYoungDriver) {
        this.isYoungDriver = isYoungDriver;
    }
}
