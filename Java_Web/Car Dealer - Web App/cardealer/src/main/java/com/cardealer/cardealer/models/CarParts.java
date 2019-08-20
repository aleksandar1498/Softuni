package com.cardealer.cardealer.models;

public class CarParts {
    private String carMake;
    private String carModel;
    private Long travelledDistance;
    private String partName;
    private Double price;

    public CarParts(String carMake, String carModel, Long travelledDistance, String partName, Double price) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.travelledDistance = travelledDistance;
        this.partName = partName;
        this.price = price;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
