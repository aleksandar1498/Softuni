package com.estateagency.estateagency.service;

import com.estateagency.estateagency.entities.Offer;

import java.util.List;

public interface OfferService {
    void registerOffer(OfferServiceModel offerServiceModel);
    List<Offer> getAll();
}
