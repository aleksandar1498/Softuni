package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.repositories.CarsRepository;
import com.cardealer.cardealer.services.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getCarById(@PathVariable(name = "make") String make) {
        System.out.println(make);
        List<Car> cars =this.carService.findCarByMake(make);
        return cars.toString();
    }
}
