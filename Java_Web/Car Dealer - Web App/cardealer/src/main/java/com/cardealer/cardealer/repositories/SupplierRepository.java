package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Supplier;
import com.cardealer.cardealer.entities.Parts;
import com.cardealer.cardealer.entities.SupplierParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "SELECT s FROM Supplier s WHERE s.isImporter = 0")
    List<Supplier> getLocalSuppliers();
    @Query(value = "SELECT s FROM Supplier s WHERE s.isImporter = 1")
    List<Supplier> getImportedSuppliers();
    @Query(value = "SELECT new com.cardealer.cardealer.entities.SupplierParts(s.supplierId,s.name,p.id,p.name) FROM Supplier AS s LEFT JOIN Parts AS p ON s.supplierId=p.supplierId GROUP BY s.supplierId, s.name")
    List<SupplierParts> getLocalSuppliersWithOfferedParts();
}
