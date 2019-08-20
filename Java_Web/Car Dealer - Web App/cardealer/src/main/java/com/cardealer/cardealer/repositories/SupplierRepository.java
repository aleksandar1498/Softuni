package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Supplier;
import com.cardealer.cardealer.models.SupplierParts;
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
    @Query(value = "SELECT new com.cardealer.cardealer.models.SupplierParts(s.supplierId,s.name,COUNT(p.partId)) FROM Supplier AS s LEFT JOIN Parts AS p ON s.supplierId=p.supplierId WHERE s.isImporter = 0 GROUP BY s.supplierId, s.name")
    List<SupplierParts> getLocalSuppliersWithOfferedParts();
    @Query(value = "SELECT new com.cardealer.cardealer.models.SupplierParts(s.supplierId,s.name,COUNT(p.partId)) FROM Supplier AS s LEFT JOIN Parts AS p ON s.supplierId=p.supplierId WHERE s.isImporter = 1 GROUP BY s.supplierId, s.name")
    List<SupplierParts> getImportedSuppliersWithOfferedParts();
}
