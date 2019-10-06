package com.interview.preparation.javarevisited;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = new int[130000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (1 +(Math.random() * 10));
        }
        //4919829101
        //200206200

        long start = System.nanoTime();
      // quickSort(arr, 0, arr.length);
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        System.out.println(System.nanoTime() - start);
    }
    private static int partitionAlgorithm(int []arr,int low,int high){
        // takes the last element and places it to the correct position , all the greater will be placed on the right, while the inferior are placed on the left
        int indexOfSmallest = low;
        int pivot = arr[high-1];
        for (int i = low; i < high-1; i++) {
            if(arr[i] < pivot){
                int temp = arr[indexOfSmallest];
                arr[indexOfSmallest] = arr[i];
                arr[i] = temp;
                indexOfSmallest++;
            }

        }
        int temp = arr[high-1];
        arr[high-1] = arr[indexOfSmallest];
        arr[indexOfSmallest] = temp;
        return indexOfSmallest;
    }
    private static void quickSort(int [] arr,int low ,int high){
        if(low < high){
            int pi = partitionAlgorithm(arr,low,high);

            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
}
