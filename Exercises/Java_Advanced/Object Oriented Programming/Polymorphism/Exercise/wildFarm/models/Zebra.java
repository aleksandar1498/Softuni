package wildFarm.models;

import wildFarm.abstracts.Food;
import wildFarm.abstracts.Mammal;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
            return;
        }

        throw new IllegalArgumentException("Zebras are not eating that type of food!");

    }

}
