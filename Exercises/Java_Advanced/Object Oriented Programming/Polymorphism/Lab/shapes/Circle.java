package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    double calculatePerimeter() {
        return this.getRadius()*2*Math.PI;
    }

    @Override
    double calculateArea() {
        return this.getRadius()*this.getRadius()*Math.PI;
    }
}
