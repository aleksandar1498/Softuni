package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.products=new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getTotalCalories(){
        return products.stream().mapToInt(Vegetable::getCalories).sum();
    }
    public int getProductCount(){
        return this.products.size();
    }
    public void add(Vegetable v){
        this.products.add(v);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
         stringBuilder.append(String.format("* Salad %s is %d calories and have %d products:%n",this.getName(),this.getTotalCalories(),this.getProductCount()));
        for (Vegetable product : this.products) {
            stringBuilder.append(product.toString());

        }
        return stringBuilder.toString();
    }
}
