package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    double calculatePerimeter() {
        return this.getHeight()*2+this.getWidth()*2;
    }

    @Override
    double calculateArea() {
        return this.getHeight()*this.getWidth();
    }
}
