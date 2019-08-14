package com.estateagency.estateagency.controllers;

import com.estateagency.estateagency.entities.Offer;
import com.estateagency.estateagency.models.OfferModel;
import com.estateagency.estateagency.repositories.OfferRepository;
import com.estateagency.estateagency.service.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class HomeController {

    private AgencyService agencyService ;

    public HomeController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }


    @GetMapping("/")
    public ModelAndView showHome(ModelAndView modelAndView){
        modelAndView.addObject("offers",this.agencyService.getAllOffers());
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
    @GetMapping("/find")
    public ModelAndView showFindPage(ModelAndView modelAndView){
        modelAndView.setViewName("find.html");
        return modelAndView;
    }
    @GetMapping("/reg")
    public ModelAndView showRegisterPage(ModelAndView modelAndView){
        modelAndView.addObject("offermodel",new OfferModel());
        modelAndView.setViewName("register.html");
        return modelAndView;
    }
    @PostMapping("/reg")
    public String registerOffer(OfferModel offer){
        Offer offerToPass = new Offer();
        offerToPass.setId(offer.getId());
        offerToPass.setAgencyCommission(offer.getAgencyCommission());
        offerToPass.setApartmentRent(offer.getApartmentRent());
        offerToPass.setApartmentType(offer.getApartmentType());
        this.agencyService.addOffer(offerToPass);
        return "redirect:/";
    }
}
