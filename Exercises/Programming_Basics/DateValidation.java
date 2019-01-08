package com.softuni;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidation {
    // pattern used to find if the inserted data is valid
    Pattern date = Pattern.compile("^([1-9]|1\\d|2\\d|3[01])-([1-9]|1[0-2])-(19|20|18|17|16)\\d{2}$");
    public String ourData = "";

    public DateValidation(String s) {
        if (isValid(s)) {

            System.out.println("your data is valid ");
            this.ourData = s;
        } else {
            System.out.println("Your data is not valid");
            System.exit(0);
        }
    }

    boolean isValid(String day) {
        Matcher data = date.matcher(day);
        if (data.find()) {
            String [] dataElements=day.split("-");
            int d=Integer.valueOf(dataElements[0]);
            int m=Integer.valueOf(dataElements[1]);
            int y=Integer.valueOf(dataElements[2]);
            System.out.println(d+" "+m+" "+y+" "+isLeapYear(y));
            if( (m==4 || m==6 || m==9 || m== 1 || m==11) && d!=30){

                System.out.println("a");
                return false;

            }
            if((m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m == 12) && d!= 31){
                System.out.println("b");
                return false;
            }
            if((isLeapYear(y) == true) && (m==2) && d>28){

                    System.out.println("Is leap year and month is fabruary");
                    return false;



            }else if(m==2 && d > 29){
                System.out.println("It is not a leap year");
                return  false;
            }

            return true;
        }else {
            System.out.println("c");
            return false;
        }
    }
    static boolean isLeapYear(int y){
        if(y % 4 == 0){
            if(y % 400 != 0 && y %100 == 0){
                return false;
            }else{
                return  true;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        DateValidation d = new DateValidation("28-2-1800");

    }
}
