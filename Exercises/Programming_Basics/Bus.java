package com.softuni;

import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numPassagersAtStart=Integer.parseInt(scanner.nextLine());
        int numStops=Integer.parseInt(scanner.nextLine());
        int totPeople=numPassagersAtStart;
        for (int i = 1; i <= numStops; i++) {
            int peopleOut=Integer.parseInt(scanner.nextLine());
            int peopleIn=Integer.parseInt(scanner.nextLine());
           totPeople+=peopleIn;
           totPeople-=peopleOut;
            if(i%2 == 0){
                totPeople-=2;
            }else{
                totPeople+=2;
            }
        }
        System.out.println("The final number of passengers is : "+totPeople);
    }
}
