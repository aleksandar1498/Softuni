package com.softuni;

import java.util.Scanner;

public class PCStore {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceCPUInDollars=Double.parseDouble(scanner.nextLine());
        double priceGPUInDollars=Double.parseDouble(scanner.nextLine());
        double priceRAMInDollars=Double.parseDouble(scanner.nextLine());
        int numRAMs=Integer.parseInt(scanner.nextLine());
        double discount=Double.parseDouble(scanner.nextLine());
        double totPrice=0.0;
        totPrice+=((priceCPUInDollars+priceGPUInDollars)*(1-discount))+(numRAMs*priceRAMInDollars);
        System.out.printf("Money needed - %.2f leva.",totPrice*1.57);
    }
}
