package pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] coordinates= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Point topLeft=new Point(coordinates[0],coordinates[1]);
        Point bottomRight=new Point(coordinates[2],coordinates[3]);
        Rectangle rectangle=new Rectangle(topLeft,bottomRight);
        int numPoints=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numPoints; i++) {
            int [] pointCoords= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point p=new Point(pointCoords[0],pointCoords[1]);
            System.out.println(rectangle.contains(p));

        }
    }
}
