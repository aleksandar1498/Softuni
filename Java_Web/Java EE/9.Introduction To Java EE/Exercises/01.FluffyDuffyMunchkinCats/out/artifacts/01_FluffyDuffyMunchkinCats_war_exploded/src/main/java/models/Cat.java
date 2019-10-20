package models;

public class Cat {
    private String name;
    private String breed;
    private String color;
    private int numLegs;

    public Cat(String name, String breed, String color, int numLegs) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.numLegs = numLegs;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public String getColor() {
        return this.color;
    }

    public int getNumLegs() {
        return this.numLegs;
    }
}
