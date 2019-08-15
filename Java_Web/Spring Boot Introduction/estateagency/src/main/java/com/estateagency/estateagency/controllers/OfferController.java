package com.estateagency.estateagency.controllers;

import com.estateagency.estateagency.entities.Offer;
import com.estateagency.estateagency.models.FindOfferModel;
import com.estateagency.estateagency.models.OfferModel;
import com.estateagency.estateagency.repositories.OfferRepository;
import com.estateagency.estateagency.service.FindServiceModel;
import com.estateagency.estateagency.service.OfferService;
import com.estateagency.estateagency.service.OfferServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

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
        modelAndView.addObject("findModel",new FindOfferModel());
        modelAndView.setViewName("find.html");
        return modelAndView;
    }
    @PostMapping("/find")
    public String showFindPage(@ModelAttribute(name = "findmodel")FindOfferModel offerModel) {
        try{
            this.offerService.find(modelMapper.map(offerModel, FindServiceModel.class));
        }catch (IllegalArgumentException ex){
            return "redirect:/find";
        }
        return "redirect:/";
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
