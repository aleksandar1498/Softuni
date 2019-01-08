package com.softuni;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int timeNeeded=Integer.parseInt(scanner.nextLine());
        int numWorkers=Integer.parseInt(scanner.nextLine());
        int workingDays=Integer.parseInt(scanner.nextLine());
        if(numWorkers*(workingDays*8) >= timeNeeded){
            System.out.printf("%d hours left",numWorkers*(workingDays*8)-timeNeeded);
        }else{
            System.out.printf("%d overtime\n",timeNeeded-numWorkers*(workingDays*8));
            System.out.printf("Penalties: %d",(timeNeeded-numWorkers*(workingDays*8))*workingDays);
        }
    }
}
