package com.cardealer.cardealer.services.supplier;

import com.cardealer.cardealer.entities.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> showLocal();
    List<Supplier> showImported();
}
