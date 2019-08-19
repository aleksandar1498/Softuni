package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "SELECT s FROM Supplier s WHERE s.isImporter = 0")
    List<Supplier> getLocalSuppliers();
}
