package oop.catlady;

public class Cymric extends Cat {
    double furLength;

    public Cymric(String name, double furLength) {
        this(name);
        this.furLength = furLength;
    }
    public Cymric(String name) {
        super(name);
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",this.getClass().getSimpleName(),super.getName(),this.getFurLength());
    }
}
