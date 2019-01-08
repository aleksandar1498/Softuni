import java.util.Scanner;

public class WeddingHall {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double length=Double.parseDouble(scanner.nextLine());
        double width=Double.parseDouble(scanner.nextLine());
        double widthBar=Double.parseDouble(scanner.nextLine());
        double totArea=length*width;
        totArea-=totArea*.19;
        totArea-=widthBar*widthBar;
        System.out.printf("%.0f",Math.ceil(totArea/3.2));
    }
}
