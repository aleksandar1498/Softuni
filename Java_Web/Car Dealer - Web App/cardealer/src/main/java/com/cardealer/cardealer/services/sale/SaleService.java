package com.cardealer.cardealer.services.sale;

import com.cardealer.cardealer.models.SaleModel;

import java.util.List;

public interface SaleService {
    List<SaleModel> getAllSales();
    List<SaleModel> getAllSalesByCustomer(Long id);
    List<SaleModel> getAllDiscountedSales();
    List<SaleModel> getAllSalesWithDiscountOf(Double discount);
}
