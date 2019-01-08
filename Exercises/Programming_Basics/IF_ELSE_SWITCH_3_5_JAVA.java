package com.softuni;

import java.util.Scanner;

public class IF_ELSE_SWITCH_3_5_JAVA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* EX 2
                        int x=Integer.parseInt(scanner.nextLine());
                        if(x%2 == 0){
                            x/=2;
                        }else{
                            x=(x*3)-1;
                        }
                        System.out.println(x);*/

       /*
        EX 3
       String answer=scanner.nextLine();
                      // solution 1
                       switch (answer){
                           case "si" :
                           case "Si":
                           case "s":
                           case "S":
                               System.out.println("accepted");
                               break;
                           default:
                               System.out.println("not accepted");
                                   break;
                       };


                       // solution 2
                        if(answer.equalsIgnoreCase("si") || answer.equalsIgnoreCase("s")){
                            System.out.println("accepted");
                        }else{
                            System.out.println("not accepted");
                        }
       */
       /* EX 6
                       double amountMoney=Integer.parseInt(scanner.nextLine());
                       if(amountMoney <= 10){
                           System.out.println("cost of the service 1 euro");
                       }else if( amountMoney <= 100){
                           System.out.println("cost of the service "+(amountMoney*.1));
                       }else if(amountMoney <= 1000){
                           System.out.println("cost of the service "+(5+(amountMoney*.05)));
                       }else{
                           System.out.println("cost of the service "+(40+(amountMoney*.01)));
                       }
       */

       String mark=scanner.nextLine();
       double convertedMark=0;

           switch (mark.charAt(0)){
               case 'a':
               case 'A':
                   convertedMark=4.0;
                   break;
               case 'b':
               case 'B':
                   convertedMark=3.0;
                   break;
               case 'c':
               case 'C':
                   convertedMark=2.0;
                   break;
               case 'd':
               case 'D':
                   convertedMark=1.0;
                   break;
               case 'f':
               case 'F':
                   convertedMark=0.0;
                   break;
               default:
                   System.out.println("Mark not valid");
           }
        if(mark.length() == 1){
            System.out.println("Your mark is "+convertedMark);
        }else{
            for(char c: mark.substring(1,mark.length()).toCharArray()){

                if(c == '+'){
                    convertedMark+=.25;
                }else if(c == '-'){
                    convertedMark-=.25;
                }
            }
            System.out.println("Your decimal mark is "+convertedMark);

        }
    }
}
