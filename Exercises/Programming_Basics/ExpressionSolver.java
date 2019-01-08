package com.softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExpressionSolver {
    public static void main(String[] args) {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in)) ;
        int symbol = 0;
        double result=0;
        char operator='+';
        while(symbol != '='){
            try {
                symbol=reader.read();
               if(symbol == '('){
                   char operator2='+';
                   double result2=0;
                   while (symbol != ')'){
                       try {
                           symbol=reader.read();
                           if(symbol == '('){
                               System.out.println("error! you cannot use a nested ( ( ) )");
                               System.exit(0);
                           }else if( symbol-'0' >= 0 && symbol-'0' <=9) {
                               switch (operator2){
                                   case '+':
                                       result2+=(int)(symbol-'0');
                                       break;
                                   case '-':
                                       result2-=symbol-'0';
                                       break;
                                   case '*':
                                       result2*=symbol-'0';
                                       break;
                                   case '/':
                                       result2/=symbol-'0';
                                       break;
                               }

                           }else if(symbol == '+' || symbol == '-' || symbol == '/' || symbol == '*'){
                               operator2=(char)symbol;

                           }
                       }catch(Exception e){
                           System.out.println(e);
                       }
                   }
                   switch (operator){
                       case '+':
                           result+=result2;
                           break;
                       case '-':
                           result-=result2;
                           break;
                       case '*':
                           result*=result2;
                           break;
                       case '/':
                           result/=result2;
                           break;
                   }
               }else if( symbol-'0' >= 0 && symbol-'0' <=9) {
                    switch (operator){
                        case '+':
                            result+=(int)(symbol-'0');
                            break;
                        case '-':
                            result-=symbol-'0';
                            break;
                        case '*':
                            result*=symbol-'0';
                            break;
                        case '/':
                            result/=symbol-'0';
                            break;
                    }

                }else if(symbol == '+' || symbol == '-' || symbol == '/' || symbol == '*'){
                    operator=(char)symbol;

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.printf("%.2f",result);


    }
}
