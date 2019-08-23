package com.cardealer.cardealer.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CustomerBindingModel {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 5,max = 10,message = "The name length must be between 5 and 10")
    private String name;

    private java.util.Date birthDate;
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
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        System.out.println();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");

        this.birthDate = formatter.parse(birthDate);
    }

    public int getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(int isYoungDriver) {
        this.isYoungDriver = isYoungDriver;
    }
}
