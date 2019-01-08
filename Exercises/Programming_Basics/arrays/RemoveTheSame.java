package com.softuni.arrays;

import java.util.Scanner;

public class RemoveTheSame {
    public static char[] removeTheSame(char [] in){
        String result="";
        for (int i = 0; i < in.length; i++) {
            if(in[i] != '-'){
                result=result.concat(""+in[i]);
            }
            for (int j = i+1; j < in.length; j++) {
                if(in[i] == in[j]){
                    in[j]='-';
                }
            }
        }

        return result.toCharArray();
    }
    public static int[] remove(int v,int [] in){

        int length=0,count=0;
        for (int i = 0; i < in.length; i++) {
            if(in[i] != v){
                length++;
            }

        }
        int [] result=new int[length];
        for (int i = 0; i < in.length; i++) {
            if(in[i] != v){
               result[count]=in[i];
               count++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       /* char [] letters=new char[]{'b','d','a','b','f','a','g','a','a','f','h'};
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]+" ");
        }
       letters=removeTheSame(letters);
        System.out.println("IN");
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]+" ");
        }*/
       int [] digits =new int[]{1,2,3,3,4,1,2,8};
     digits=remove(3,digits);
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]+" ");
        }
    }
}
