package com.estateagency.estateagency.service;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class FindServiceModel {
    private String familyName;
    private String offerType;
    private BigDecimal familyBudget;

    public FindServiceModel() {
    }
    @NotNull
    @NotEmpty
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    @NotNull
    @NotEmpty
    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }
    @NotNull
    @DecimalMin("0")
    public BigDecimal getFamilyBudget() {
        return familyBudget;
    }

    public void setFamilyBudget(BigDecimal familyBudget) {
        this.familyBudget = familyBudget;
    }
}
