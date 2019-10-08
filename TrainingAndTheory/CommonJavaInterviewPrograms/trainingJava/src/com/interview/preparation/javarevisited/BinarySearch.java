package com.interview.preparation.javarevisited;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = new int[99999999];               // Random 10000
        for (int a = 0; a < arr.length; a++) {
            arr [a] = (int) (Math.random () * 1000);
        }
        arr[99999998] = 1415;
        arr = Arrays.stream(arr).sorted().toArray();
        int searchedNumber = 1415;
        long startingTime = System.nanoTime();
        search(searchedNumber,arr);
        System.out.println(System.nanoTime()-startingTime);
        startingTime = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == searchedNumber){
                break;
            }
        }
        System.out.println(System.nanoTime()-startingTime);
    }
    public static boolean search(int x,int [] arr){

        if(arr.length == 1){
            if(arr[0] == x){
                return true;
            }
            return false;
        }
        if(arr[arr.length/2-1] == x){
            return  true;
        }
        if(arr[arr.length/2 -1] > x){
           return search(x,Arrays.copyOfRange(arr,0,arr.length/2 -1));
        }else{
           return search(x,Arrays.copyOfRange(arr,arr.length/2,arr.length));
        }

    }

    // second implementation,looking for index
    public static int searchB(int x,int l,int h,int [] arr){
        if(h >= l){
            int mid = l + (h-l) / 2;
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] < x){
                return searchB(x,mid+1,h,arr);
            }else{
                return searchB(x,l,mid-1,arr);
            }
        }
        return -1;


    }
}
