package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.models.SaleModel;
import com.cardealer.cardealer.services.car.CarService;
import com.cardealer.cardealer.services.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "Sales")
public class SalesController {
    private final SaleService saleService;
    private final CarService carService;
    @Autowired
    public SalesController(SaleService saleService, CarService carService) {
        this.saleService = saleService;
        this.carService = carService;
    }

    @GetMapping(value = "/")
    @ResponseBody
    public String showAllSales() {
        StringBuilder builder = new StringBuilder();
        List<SaleModel> sales = this.saleService.getAllSales();
        for (SaleModel sale : sales) {
            builder.append(String.format("Car : %s %s %d Customer: %s Sale : %.2f",
                    sale.getCar().getMake(),
                    sale.getCar().getModel(),
                    sale.getCar().getTravelledDistance(),
                    sale.getCustomer().getName(),
                    this.carService.getTotalPrice(sale.getCar().getCarId()))).append("</br>");
        }
        return builder.toString();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String showAllSales(@PathVariable("id") Long id) {
        StringBuilder builder = new StringBuilder();
        List<SaleModel> sales = this.saleService.getAllSalesByCustomer(id);
        for (SaleModel sale : sales) {
            builder.append(String.format("Car : %s %s %d Customer: %s",
                    sale.getCar().getMake(),
                    sale.getCar().getModel(),
                    sale.getCar().getTravelledDistance(),
                    sale.getCustomer().getName()
                    )).append("</br>");
        }
        return builder.toString();
    }
/*
    @GetMapping(value = "/discounted")
    @ResponseBody
    public void showAllSales() {
        StringBuilder builder = new StringBuilder();
        List<SaleModel> sales = this.saleService.getAllSalesByCustomer(id);
        for (SaleModel sale : sales) {
            builder.append(String.format("Car : %s %s %d Customer: %s",
                    sale.getCar().getMake(),
                    sale.getCar().getModel(),
                    sale.getCar().getTravelledDistance(),
                    sale.getCustomer().getName()
            )).append("</br>");
        }
        return builder.toString();
    }

    @GetMapping(value =)
    @ResponseBody
    public void showAllSales() {

    }*/
}
