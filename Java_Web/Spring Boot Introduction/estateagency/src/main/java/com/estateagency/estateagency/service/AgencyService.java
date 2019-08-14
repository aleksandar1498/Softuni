package com.estateagency.estateagency.service;

import com.estateagency.estateagency.entities.Offer;
import com.estateagency.estateagency.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final OfferRepository offerRepository;


    public AgencyService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
    public void addOffer(Offer offer){
        this.offerRepository.save(offer);
    }
    public List<Offer> getAllOffers(){
        return this.offerRepository.findAll();
    }
}
