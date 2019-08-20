package com.cardealer.cardealer.services.sale;

import com.cardealer.cardealer.models.SaleModel;
import com.cardealer.cardealer.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleServiceImpl implements SaleService {
    private final SalesRepository salesRepository;

    @Autowired
    public SaleServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<SaleModel> getAllSales() {
        return this.salesRepository.getAllSales();
    }

    @Override
    public List<SaleModel> getAllSalesByCustomer(Long id) {
        return this.salesRepository.getAllSalesByGivenCustomerId(id);
    }

    @Override
    public List<SaleModel> getAllDiscountedSales() {
        return this.salesRepository.getAllSalesDiscounted();
    }

    @Override
    public List<SaleModel> getAllSalesWithDiscountOf(Double discount) {
        return this.salesRepository.getAllSalesDiscountedBy(discount);
    }
}
