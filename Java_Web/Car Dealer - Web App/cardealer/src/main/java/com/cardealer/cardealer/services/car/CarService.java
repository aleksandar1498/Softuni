package com.cardealer.cardealer.services.car;

import com.cardealer.cardealer.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> findCarByMake(String make);
}
