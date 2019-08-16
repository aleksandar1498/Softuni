package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT c FROM Car c WHERE c.make = :make")
    List<Car> findAllByMake(@Param("make") String make);
}
