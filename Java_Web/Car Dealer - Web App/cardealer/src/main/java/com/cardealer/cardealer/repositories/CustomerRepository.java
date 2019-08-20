package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT c FROM Customer c ORDER BY c.birthDate ASC")
    List<Customer> findAllOrderedByDateAsc();
    @Query(value = "SELECT c FROM Customer c ORDER BY c.birthDate DESC")
    List<Customer> findAllOrderedByDateDesc();
    @Query(value = "SELECT car FROM Customer c JOIN Sales s on c.id=s.customerId JOIN Car car ON s.carId = car.carId WHERE c.id=:id")
    List<Car> findAllCarsBoughtByUser(Long id);
}
