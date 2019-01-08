package com.softuni;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String fruit=scanner.nextLine();
        String day=scanner.nextLine();
        double quantity=Double.parseDouble(scanner.nextLine());
        if(day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")){
            switch (fruit){
                case "banana":
                    System.out.printf("%.2f",quantity*2.5);
                    break;
                case "apple":
                    System.out.printf("%.2f",quantity*1.2);
                    break;
                case "orange" :
                    System.out.printf("%.2f",quantity*.85);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f",quantity*1.45);
                    break;
                case "kiwi":
                    System.out.printf("%.2f",quantity*2.7);
                    break;
                case "pineapple":
                    System.out.printf("%.2f",quantity*5.5);
                    break;
                case "grapes":
                    System.out.printf("%.2f",quantity*3.85);
                    break;
                    default:
                        System.out.println("error");
            }
        }else if(day.equals("Saturday") || day.equals("Sunday")){
            switch (fruit){
                case "banana":
                    System.out.printf("%.2f",quantity*2.7);
                    break;
                case "apple":
                    System.out.printf("%.2f",quantity*1.25);
                    break;
                case "orange" :
                    System.out.printf("%.2f",quantity*.9);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f",quantity*1.6);
                    break;
                case "kiwi":
                    System.out.printf("%.2f",quantity*3);
                    break;
                case "pineapple":
                    System.out.printf("%.2f",quantity*5.6);
                    break;
                case "grapes":
                    System.out.printf("%.2f",quantity*4.2);
                    break;
                default:
                    System.out.println("error");
            }
        }else{
            System.out.println("error");
        }
    }
}
