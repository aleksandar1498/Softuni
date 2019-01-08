package com.softuni.arrays;

import java.util.Scanner;

public class IncreasingSequence {
    public static boolean linearIncrease(double [] in){
        for (int i = 1; i < in.length; i++) {
            if(in[i] < in[i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double [] val=new double[]{2,3,4,3,6};
        System.out.println(linearIncrease(val));
    }
}
