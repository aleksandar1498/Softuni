package com.softuni;

import java.util.Scanner;

public class Metabolism {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double weight=Double.parseDouble(scanner.nextLine());
        double height=Double.parseDouble(scanner.nextLine());
        int age=Integer.parseInt(scanner.nextLine());
        double MB=0.0;
        String sex="What is your sex M or W";
            if(sex.equalsIgnoreCase("M")){
                MB=66+(13.8*weight)+(5.0*height)-(6.8*age);
            }else{
                MB=655+(9.6*weight)+(1.8*height)-(4.7*age);
            }
        System.out.println("Do you have an active routine -S -BA -A -HA");
            String active=scanner.nextLine();
            if(active.equalsIgnoreCase("S")){
                MB+=MB*.2;
            }else if(active.equalsIgnoreCase("BA")){
                MB+=MB*.3;
            }else if(active.equalsIgnoreCase("A")){
                MB+=MB*.4;
            }else if(active.equalsIgnoreCase("HA")){
                MB+=MB*.5;
            }else{
                System.out.println("Your input is not valid ");
                System.exit(0);
            }

        System.out.println(MB+" Num of barrets - Men : "+(MB/230));
      //  System.out.println("Num of barrets - Women : "+(MBWomen/230));

    }
}
