package com.softuni;

import java.util.Scanner;

public class InfestationInTheHouse {
    public static final double INFESTATION_INCREMENT = -.05;
    public static final double VOLUME = 0.00000076;

    public int neededWeeks(int numS, double volumeOfTheHouse) {
        int weeks = 0;
        while ((VOLUME * numS) < volumeOfTheHouse) {
            numS += numS * INFESTATION_INCREMENT;
            weeks++;
        }
        return weeks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfestationInTheHouse inf = new InfestationInTheHouse();
        System.out.println(inf.neededWeeks(100, 240));
    }

}
