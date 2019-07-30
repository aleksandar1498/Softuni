package exceptionHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try{
            int number = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException ex){
            System.out.println("Invalid number");
        }finally {
            System.out.println("Good bye");
        }
    }
}
