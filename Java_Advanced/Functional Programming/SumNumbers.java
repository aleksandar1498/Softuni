package lineardatastructure.functionalprogramming;

import java.util.Scanner;
import java.util.function.Function;


public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] items= scanner.nextLine().split(", ");
        Function<String,Integer> parsing= numb -> Integer.parseInt(numb);
        int sum=0;
        for (String item:
             items) {
            sum+=parsing.apply(item);
        }
        System.out.println("Count = "+items.length);
        System.out.println("Sum = "+sum);
    }
}
