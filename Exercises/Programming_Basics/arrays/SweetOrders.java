package com.softuni.arrays;

import java.util.Scanner;

public class SweetOrders {
    public static int[] combineOrder(int[] o1, int[] o2) {
        int result[] = new int[o1.length];
        for (int i = 0; i < o1.length; i++) {
            result[i] = o1[i] + o2[i];
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] order1 = {0, 0, 3, 4, 7};
        int[] order2 = {0, 4, 0, 1, 2};
        int[] combinedOrders = combineOrder(order1, order2);
        for (int order : combinedOrders){
            System.out.println(order);
        }
    }
}
