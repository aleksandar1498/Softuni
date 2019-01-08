package com.softuni;

import java.util.Scanner;

public class SumPrimes {
    public static void main(String[] args) {

    SumPrimes sp=new SumPrimes();
        Scanner scanner=new Scanner(System.in);
        int n=0;

        do{
            System.out.println("Insert");
            n=Integer.parseInt(scanner.nextLine());
        }while(!sp.isPrime(n));
        int sum=0;
        for(int x=n;x>=1;x--){

            if(sp.isPrime(x)){
                System.out.println(x);
                sum+=x;
            }
        }
       System.out.println(sum);
    }
    boolean isPrime(int i){
        int multiple=1,n=0;
        while(multiple <= i){
            if(i%multiple == 0){
             //   System.out.println("is a multiple "+multiple);
              n++;
            }
            //System.out.println(multiple);
            multiple++;
        }
        if(n==2) {
            return true;
        }else{
            return false;
        }
    }

}
