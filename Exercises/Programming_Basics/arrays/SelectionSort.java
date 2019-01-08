package com.softuni.arrays;

import java.util.Scanner;

public class SelectionSort {
    public static int [] selectionSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            int indexNextSmallest=nextSmallest(i,array);
            int temp=array[i];
            array[i]=array[indexNextSmallest];
            array[indexNextSmallest]=temp;
        }
        return array;
    }
    public static int [] partialSelectionSort(int [] array,int begin,int end){
        end=((end <= array.length)? end:array.length );
        for (int i = ((begin <= 0)? 0: begin ); i < end;i++) {
            int indexNextSmallest=nextSmallest(i,array,end);
            int temp=array[i];
            array[i]=array[indexNextSmallest];
            array[indexNextSmallest]=temp;
        }
        return array;
    }
    public static int nextSmallest(int index,int [] arr){
        int nextSmallest=Integer.MAX_VALUE,nextIndex=0;
        for(int i=index;i<arr.length;i++){
            if(arr[i] < nextSmallest){
                nextSmallest=arr[i];
                nextIndex=i;
            }
        }
        return nextIndex;
    }
    public static int nextSmallest(int index,int [] arr,int end){
        int nextSmallest=Integer.MAX_VALUE,nextIndex=0;
        for(int i=index;i<end;i++){
            if(arr[i] < nextSmallest){
                nextSmallest=arr[i];
                nextIndex=i;
            }
        }
        return nextIndex;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] array = {7,6,11,17,3,15,5,19,30,14};
        //int [] orderedArray=selectionSort(array);
        int [] partialOrderArray=partialSelectionSort(array,1,6);
        //for (int val:orderedArray){
          //  System.out.print(val+" ");
        //}
        System.out.println();
        for (int val1:partialOrderArray){
            System.out.print(val1+" ");
        }
    }
}
