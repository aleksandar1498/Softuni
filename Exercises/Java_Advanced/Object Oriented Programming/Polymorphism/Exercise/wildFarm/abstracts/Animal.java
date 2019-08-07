package wildFarm.abstracts;

import wildFarm.interfaces.Feedable;
import wildFarm.interfaces.Soundable;

import java.text.DecimalFormat;

public abstract class Animal implements Feedable, Soundable {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;

    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }


    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
}


