package com.softuni.arrays;

import java.util.Scanner;

public class NumberUnderTheAverage {
    Scanner scanner=new Scanner(System.in);
    public int[] readTemperature(int n){
        int [] temperature=new int[n];
        for (int i = 0; i < n; i++) {
            temperature[i]=Integer.parseInt(scanner.nextLine());
        }
        return temperature;
    }
    public double average(int [] temperature){
        double sum=0;
        for(int temp:temperature){
            sum+=temp;
        }
        return sum/temperature.length;
    }
    public static void main(String[] args) {
        NumberUnderTheAverage nb=new NumberUnderTheAverage();
        int [] temp=nb.readTemperature(10);
        double average=nb.average(temp);
        System.out.println(average);
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] < average){
                System.out.println(temp[i]+" is under the average");
            }else{
                System.out.println(temp[i]+" is higher than the average");
            }
        }
    }
}
