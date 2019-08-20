package com.cardealer.cardealer.services.car;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.models.CarParts;

import java.util.List;

public interface CarService {
    List<Car> findCarByMake(String make);

    List<CarParts> findCarPartsByCarId(Long id);
}
