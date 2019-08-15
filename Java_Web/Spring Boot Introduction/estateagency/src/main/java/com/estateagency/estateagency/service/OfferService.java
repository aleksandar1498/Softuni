package com.estateagency.estateagency.service;

import com.estateagency.estateagency.entities.Offer;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {
    void registerOffer(OfferServiceModel offerServiceModel);
    void find(FindServiceModel findServiceModel);
    List<Offer> getAll();
}
