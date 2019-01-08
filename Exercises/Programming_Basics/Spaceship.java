package com.softuni;

import java.util.Scanner;

public class Spaceship {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double widthOfTheShip=Double.parseDouble(scanner.nextLine());
        double lengthOfTheShip=Double.parseDouble(scanner.nextLine());
        double heightOfTheShip=Double.parseDouble(scanner.nextLine());
        double heightOfTheAstronauts=Double.parseDouble(scanner.nextLine());
        double volumeOfTheShip=widthOfTheShip*lengthOfTheShip*heightOfTheShip;
        double volumeOfOneRoom=(heightOfTheAstronauts+.4)*2*2;
        int numAstronauts=(int)Math.floor(volumeOfTheShip/volumeOfOneRoom);
    if(numAstronauts >=3 && numAstronauts <= 10){
        System.out.printf("The spacecraft holds %d astronauts.",numAstronauts);
    }else if(numAstronauts < 3){
        System.out.println("The spacecraft is too small.");
    }else{
        System.out.println("The spacecraft is too big.");
    }
    }
}
