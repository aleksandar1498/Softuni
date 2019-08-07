package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] token=scanner.nextLine().split("\\s+");
        Double pricePerDay=Double.parseDouble(token[0]);
        int numDays=Integer.parseInt(token[1]);
        Season season =Season.valueOf(token[2]);
        Discount discount = Discount.valueOf(token[3]);

        System.out.printf("%.2f%n",PriceCalculator.calculatePrice(pricePerDay,numDays,season,discount));
    }
}
