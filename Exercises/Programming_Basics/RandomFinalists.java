package com.softuni;

public class RandomFinalists {
    public static void main(String[] args) {
        int [] finalists=new int[3];
        boolean valid=true;
        for (int i = 0; i < finalists.length; i++) {
            finalists[i] = (int) (Math.random() * 10) + 1;
            do {
                // I am resetting to valid
                valid=true;



                System.out.println(" i : "+i+" -> "+finalists[i]+" ");
                for (int j = i - 1; j >= 0; j--) {
                    //  System.out.println(finalists[i]+" j "+finalists[j]);
                    if (finalists[i] == finalists[j]) {
                        System.out.print("They are equals ");
                        System.out.println(finalists[i] + " " + finalists[j]);
                        //
                        valid = false;
                        finalists[i] = (int) (Math.random() * 10) +1 ;
                        System.out.println("new value -> "+finalists[i]);
                        break;
                    }
                }
            }while (valid == false);


        }
        System.out.println();
        for (int i = 0; i < finalists.length; i++) {
            System.out.print(finalists[i]+" ");
        }
    }
}
