package com.interview.preparation.softwaretestinghelp;

import java.io.*;
import java.util.Scanner;

public class ReverseStringWithoutUsingInbuiltFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        String reversed = "";
        for(int i = word.length()-1 ; i >= 0;i--){
            reversed+=word.charAt(i);
        }
        System.out.println(reversed);
    }
}
