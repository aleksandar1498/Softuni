package com.estateagency.estateagency.service;

import com.estateagency.estateagency.entities.Offer;
import com.estateagency.estateagency.models.OfferModel;
import com.estateagency.estateagency.repositories.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;


@Service
public class OfferServiceImpl implements OfferService {
    // Used to validate our input
    private final Validator validator;
    // This is our Repo
    private final OfferRepository offerRepository;
    // Needed to map the OfferServiceModel to the entity Offer
    private final ModelMapper modelMapper;
    @Autowired
    public OfferServiceImpl(Validator validator, OfferRepository offerRepository, ModelMapper modelMapper) {
        this.validator = validator;
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {
        if(validator.validate(offerServiceModel).size() != 0){
            throw new IllegalArgumentException("Something went wrong");
        }
        this.offerRepository.saveAndFlush(modelMapper.map(offerServiceModel, Offer.class));
    }

    @Override
    public List<Offer> getAll() {
        return this.offerRepository.findAll();
    }
}
