package com.cardealer.cardealer.services.car;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.models.CarParts;
import com.cardealer.cardealer.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Car> findCarByMake(String make) {
        List<Car> cars = this.carsRepository.findAllByMake(make);
        return cars.stream().sorted((c1, c2) -> {
            int sort = c1.getModel().compareTo(c2.getModel());
            if (sort == 0) {
                sort = Long.compare(c2.getTravelledDistance(), c1.getTravelledDistance());
            }
            return sort;
        }).collect(Collectors.toList());


    }

    @Override
    public List<CarParts> findCarPartsByCarId(Long id) {
        return this.carsRepository.findAllPartsByCarId(id);
    }
}
