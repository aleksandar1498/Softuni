package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.products = new ArrayList<>();
        this.setName(name);
        this.setMoney(money);
    }

    public void buyProduct(Product product) {
        if(this.getMoney() < product.getCost()){
            System.out.printf("%s can't afford %s%n",this.name,product.getName());

        }else{
            this.products.add(product);
            this.setMoney(this.getMoney()-product.getCost());
            System.out.printf("%s bought %s%n",this.name,product.getName());
        }


    }

    private void setName(String name) {
        if(name.length() == 0 || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private double getMoney() {
        return money;
    }

    private List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return String.format("%s - %s",this.getName(),(this.getProducts().size() > 0)?this.getProducts().toString().replaceAll("[\\[\\]]",""):"Nothing bought");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
