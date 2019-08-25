package com.cardealer.cardealer.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class PartModel {
    private long partId;
    @NotEmpty
    private String name;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10000")
    private Double price;
    @NotNull
    @Min(1)
    @Max(10000)
    private int quantity;
    @NotNull
    private long supplierId;

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

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }
}
