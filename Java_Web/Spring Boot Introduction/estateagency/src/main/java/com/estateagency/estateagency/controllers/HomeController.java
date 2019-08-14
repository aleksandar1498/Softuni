package com.estateagency.estateagency.controllers;

import com.estateagency.estateagency.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final OfferService offerService ;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/")
    public ModelAndView showHome(ModelAndView modelAndView){
        modelAndView.addObject("offers",this.offerService.getAll());
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

}
