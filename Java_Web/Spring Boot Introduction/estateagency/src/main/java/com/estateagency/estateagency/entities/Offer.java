package com.estateagency.estateagency.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "apartment_rent")
    private BigDecimal apartmentRent;
    @Column(name = "apartment_type")
    private String apartmentType;
    @Column(name = "agency_commission")
    private BigDecimal agencyCommission;

    public BigDecimal getApartmentRent() {
        return apartmentRent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApartmentRent(BigDecimal apartmentRent) {
        this.apartmentRent = apartmentRent;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public BigDecimal getAgencyCommission() {
        return agencyCommission;
    }

    public void setAgencyCommission(BigDecimal agencyCommission) {
        this.agencyCommission = agencyCommission;
    }
}
