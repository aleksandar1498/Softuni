package arrays;

import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int length=Integer.parseInt(scanner.nextLine());
        int [] numbers=new int[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=Integer.parseInt(scanner.nextLine());
        }
        for (int j = numbers.length-1; j >= 0 ; j--) {
            System.out.println(numbers[j]);
        }
    }
}
