package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Sales;
import com.cardealer.cardealer.models.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Long> {
    @Query(value = "SELECT new com.cardealer.cardealer.models.SaleModel(car,c,s.discount) FROM Customer c JOIN Sales s on c.id=s.customerId JOIN Car car ON s.carId = car.carId")
    List<SaleModel> getAllSales();
    @Query(value = "SELECT new com.cardealer.cardealer.models.SaleModel(car,c,s.discount) FROM Customer c JOIN Sales s on c.id=s.customerId JOIN Car car ON s.carId = car.carId WHERE c.id=:id")
    List<SaleModel> getAllSalesByGivenCustomerId(Long id);
    @Query(value = "SELECT new com.cardealer.cardealer.models.SaleModel(car,c,s.discount) FROM Customer c JOIN Sales s on c.id=s.customerId JOIN Car car ON s.carId = car.carId WHERE s.discount > 0")
    List<SaleModel> getAllSalesDiscounted();
    @Query(value = "SELECT new com.cardealer.cardealer.models.SaleModel(car,c,s.discount) FROM Customer c JOIN Sales s on c.id=s.customerId JOIN Car car ON s.carId = car.carId WHERE s.discount = :discount")
    List<SaleModel> getAllSalesDiscountedBy(Double discount);

}
