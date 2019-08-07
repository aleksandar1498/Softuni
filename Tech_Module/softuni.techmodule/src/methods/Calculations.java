package methods;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String typeOperation=scanner.nextLine();
double a=Double.parseDouble(scanner.nextLine());
double b=Double.parseDouble(scanner.nextLine());
        System.out.println(calculate(typeOperation,a,b));

    }

    public static double calculate(String operation, double a, double b) {
        double result=0;
        switch (operation) {
            case "add":
                result=add(a,b);
                break;
            case "substract":
                result=substract(a,b);
                break;
            case "multiply":
                result=multiply(a,b);
                break;
            case "divide":
                result=divide(a,b);
                break;
            default:
                System.out.println("Operation not avaible");
                break;
        }
        return result;
    }
    private static double add(double a ,double b){
        return a+b;
    }
    private static double substract(double a , double b){
        return a-b;
    }
    private static double divide(double a ,double b){
        return a/b;
    }
    private static double multiply(double a,double b){
        return a*b;
    }
}
