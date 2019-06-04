package oop.catlady;

public class Siamese extends Cat {
    double earSize;

    public Siamese(String name,double earSize) {
        super(name);
        this.earSize=earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",this.getClass().getSimpleName(),super.getName(),this.getEarSize());
    }
}
