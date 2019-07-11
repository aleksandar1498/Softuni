package shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle(2.0,2.0);
        Circle circle=new Circle(3.0);
        System.out.println(rectangle.calculatePerimeter()+" "+rectangle.calculateArea());
        System.out.println(circle.calculatePerimeter()+" "+circle.calculateArea());

    }
}
