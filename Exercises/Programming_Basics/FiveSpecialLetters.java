package com.softuni;


import java.util.Scanner;

public class FiveSpecialLetters {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String pattern="abcde";
        String result="";

        int init=Integer.parseInt(scanner.nextLine());
        int end=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<5;i++){
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        for (int m = 0; m < 5; m++) {

                           String word=""+pattern.charAt(i)+pattern.charAt(j)+pattern.charAt(k)+pattern.charAt(l)+pattern.charAt(m)+"";
                        if(weight(word) >= init && weight(word) <= end){
                            result+=word+" ";

                        }
                        }
                    }
                }
            }
        }
if(result.length() > 0){
    System.out.println(result.trim());
}else{
    System.out.println("No");
}

    }

    static int weight(String s) {
        String temp = "";
        int weight = 0;
        int i=1;
        for (char c : s.toCharArray()) {
            if (temp.contains("" + c + "") == false) {
                temp = temp.concat("" + c + "");
                weight += i*valChar(c);
                i++;
            }
        }

        return weight;
    }

    static int valChar(char c) {
        switch (c) {
            case 'a':
                return 5;

            case 'b':
                return -12;

            case 'c':
                return 47;

            case 'd':
                return 7;

            case 'e':
                return -32;

            default:
                return 0;

        }
    }
}
