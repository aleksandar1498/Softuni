package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.models.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT c FROM Car c WHERE c.make = :make")
    List<Car> findAllByMake(@Param("make") String make);
    @Query(value = "SELECT new com.cardealer.cardealer.models.CarParts(c.make,c.model,c.travelledDistance,p.name,p.price) FROM Car c  INNER JOIN CarParts cp ON c.carId=cp.carId INNER JOIN Parts p ON cp.partId=p.partId WHERE c.carId=:id")
    List<CarParts> findAllPartsByCarId(@Param("id") Long id);
    @Query(value = "SELECT c FROM Car c WHERE c.carId = :id")
    Car findCarById(Long id);
    @Query(value = "SELECT SUM(p.price) FROM Car c  INNER JOIN CarParts cp ON c.carId=cp.carId INNER JOIN Parts p ON cp.partId=p.partId WHERE c.carId=:id")
    Double getTotalPrice(Long id);
}
