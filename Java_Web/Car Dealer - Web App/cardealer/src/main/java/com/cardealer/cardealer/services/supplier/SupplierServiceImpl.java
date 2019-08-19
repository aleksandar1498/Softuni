package com.cardealer.cardealer.services.supplier;


import com.cardealer.cardealer.entities.Supplier;
import com.cardealer.cardealer.models.SupplierParts;
import com.cardealer.cardealer.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> showLocal() {
        return this.supplierRepository.getLocalSuppliers();
    }

    @Override
    public List<Supplier> showImported() {
        return this.supplierRepository.getImportedSuppliers();
    }

    @Override
    public List<SupplierParts> getLocalSuppliersWithOfferedParts() {
       return this.supplierRepository.getLocalSuppliersWithOfferedParts();
    }
    @Override
    public List<SupplierParts> getImportedSuppliersWithOfferedParts() {
        return this.supplierRepository.getImportedSuppliersWithOfferedParts();
    }
}
