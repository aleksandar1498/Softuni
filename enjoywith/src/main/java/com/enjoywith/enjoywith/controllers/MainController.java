package com.enjoywith.enjoywith.controllers;

import com.enjoywith.enjoywith.dao.entities.Event;
import com.enjoywith.enjoywith.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/")
public class MainController {
    private final EventService eventService;

    @Autowired
    public MainController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/here")
    public ModelAndView herePage(ModelAndView modelAndView){
        modelAndView.addObject("Alex","aleex");
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @GetMapping("/save")
    public void save(){
      Event event = new Event(10,"Alex");
      this.eventService.save(event);
    }

}
