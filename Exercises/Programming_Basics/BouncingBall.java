package com.softuni;

import java.util.Scanner;

public class BouncingBall {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int bounces=0;
        double speed=300;
        double height=0;
        height+=speed;
        while (bounces < 5){
            while(height > 0) {
                height += speed;
                height -= 96;
                speed -= 96;
                System.out.println( height );
            }
            height*=-.5;
            speed*=-.5;

            System.out.println("BOING !");
            System.out.println(height);
            System.out.println(speed);
            bounces++;
        }
    }
}
