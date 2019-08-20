package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.models.CarParts;
import com.cardealer.cardealer.repositories.CarsRepository;
import com.cardealer.cardealer.services.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarsRepository carsRepository;
    @Autowired
    public CarController(CarService carService, CarsRepository carsRepository) {
        this.carService = carService;
        this.carsRepository = carsRepository;
    }

    @GetMapping("/{make}")
    @ResponseBody
    public ModelAndView getCarById( @PathVariable(name = "make") String make ,ModelAndView modelAndView) {
        System.out.println(make);
        List<Car> cars =this.carService.findCarByMake(make);
        modelAndView.addObject("cars",cars);
        modelAndView.setViewName("./cars/ShowCars.html");
        return modelAndView;
    }
    @GetMapping("/{id}/parts")
    public ModelAndView getCarByIdAndHisRelatedParts(@PathVariable("id") Long id,ModelAndView modelAndView){
        System.out.println(id);
        List<CarParts> carParts=this.carService.findCarPartsByCarId(id);
        modelAndView.addObject("make",carParts.get(0).getCarMake());
        modelAndView.addObject("model",carParts.get(0).getCarModel());
        modelAndView.addObject("carParts",carParts);
        modelAndView.setViewName("./cars/ShowCarParts.html");
        return modelAndView;
    }
    @GetMapping("/{id}/price")
    @ResponseBody
    public String getTotalPrice(@PathVariable("id") Long id){
        return this.carService.getTotalPrice(id)+"";
    }
}
