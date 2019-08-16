package com.cardealer.cardealer.services.car;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Car> findCarByMake(String make) {
        List<Car> cars=this.carsRepository.findAllByMake(make);

        System.out.println();
        return cars;
    }
}
