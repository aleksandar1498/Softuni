package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.models.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT c FROM Car c WHERE c.make = :make")
    List<Car> findAllByMake(@Param("make") String make);
    @Query(value = "SELECT new com.cardealer.cardealer.models.CarParts(c.id,p.id) FROM Car c INNER JOIN Parts p WHERE c.id = :id")
    List<CarParts> findAllPartsByCarId(@Param("id") Long id);
}
