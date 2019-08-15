package com.estateagency.estateagency.models;

import java.math.BigDecimal;

public class FindOfferModel {
    private String familyName;
    private String offerType;
    private BigDecimal familyBudget;

    public FindOfferModel() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public BigDecimal getFamilyBudget() {
        return familyBudget;
    }

    public void setFamilyBudget(BigDecimal familyBudget) {
        this.familyBudget = familyBudget;
    }
}
