package carShopExtended;

import java.io.Serializable;

public class Seat implements Serializable, Sellable {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires%n%s sells for %.6f",
                this.getModel(),
                this.getCountryProduced(),
                this.TIRES,
                this.getModel(),
                this.getPrice()
                );
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
