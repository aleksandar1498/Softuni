package com.cardealer.cardealer.services.car;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.models.CarParts;

import java.util.List;

public interface CarService {
    List<Car> findCarByMake(String make);
    Car findCarById(Long id);
    List<CarParts> findCarPartsByCarId(Long id);

    Double getTotalPrice(Long id);
}
