package pointInRectangle;

public class Rectangle {
    Point topLeft;
    Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean contains(Point point) {
        if (
                (point.getX() >= Math.min(topLeft.getX(),bottomRight.getX()) && point.getX() <= Math.max(topLeft.getX(),bottomRight.getX())
                        &&
                (point.getY() <= Math.max(bottomRight.getY(),topLeft.getY()) && point.getY() >= Math.min(bottomRight.getY(),topLeft.getY())))){
            return true;
        }
        return false;
    }
}
