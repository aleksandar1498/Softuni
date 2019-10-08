package com.interview.preparation.javarevisited;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int [] arr ={3,7,1,44,5,3,4,1};
        // sort the array
        for(int i=0;i<arr.length-1;i++){
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                arr[i] = -1;
            }
        }
Arrays.stream(arr).filter(x -> x != -1).forEach(System.out::println);
    }
}
