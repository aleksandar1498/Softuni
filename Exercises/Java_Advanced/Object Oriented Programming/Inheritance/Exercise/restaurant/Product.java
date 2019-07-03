package restaurant;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected BigDecimal getPrice() {
        return this.price;
    }

    protected void setPrice(BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw  new IllegalArgumentException("Invalid argument");
        }
        this.price = price;
    }
}
