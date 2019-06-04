package oop.catlady;

public class StreetExtraordinaire extends Cat {
    double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }
    public StreetExtraordinaire(String name) {
        super(name);
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",this.getClass().getSimpleName(),super.getName(),this.getDecibelsOfMeows());
    }
}
