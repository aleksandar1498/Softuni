package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    /* @Query("SELECT c FROM customers c ORDER BY c.birth_date DESC")
    List<Customer> getAllOrderedByBirthDateDescOrder();*/
}
