package wildFarm.models;

import wildFarm.abstracts.Felime;
import wildFarm.abstracts.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                this.getBreed(),
                decimalFormat.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
