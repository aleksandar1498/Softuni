package com.estateagency.estateagency.controllers;

import com.estateagency.estateagency.entities.Offer;
import com.estateagency.estateagency.models.OfferModel;
import com.estateagency.estateagency.repositories.OfferRepository;
import com.estateagency.estateagency.service.OfferService;
import com.estateagency.estateagency.service.OfferServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/find")
    public ModelAndView showFindPage(ModelAndView modelAndView) {
        modelAndView.setViewName("find.html");
        return modelAndView;
    }

    @GetMapping("/reg")
    public ModelAndView showRegisterPage(ModelAndView modelAndView) {
        modelAndView.addObject("offermodel",new OfferModel());
        modelAndView.setViewName("register.html");
        return modelAndView;
    }

    @PostMapping("/reg")
    public String registerOffer(@ModelAttribute(name = "offermodel") OfferModel offer) {
        try{
            this.offerService.registerOffer(modelMapper.map(offer, OfferServiceModel.class));
        }catch (IllegalArgumentException e){
            return "redirect:/reg";
        }
        return "redirect:/";
    }
}
