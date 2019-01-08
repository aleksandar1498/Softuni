package com.softuni;

import java.time.LocalDate;
import java.util.Scanner;

public class Zodiac {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
int d=Integer.parseInt(scanner.nextLine());
int m=Integer.parseInt(scanner.nextLine());
        System.out.println(getZodiac(d,m));
    }
    public  static String getZodiac(int d,int m){
        String zodiac="";
        if((d >= 21 && m==3) || (d<= 20 && m==4)){
         zodiac="Aries";
        }else if((d >= 21 && m==4) || (d<= 20 && m==5)){
zodiac="Taurus";
        }else if((d >= 21 && m==5) || (d<= 21 && m==6)){
zodiac="Gemini";
        }else if((d >= 22 && m==6) || (d<= 22 && m==7)){
            zodiac="Cancer";
        }else if((d >= 23 && m==7) || (d<= 23 && m==8)){
            zodiac="Leo";
        }else if((d >= 24 && m==8) || (d<= 22 && m==9)){
            zodiac="Virgo";
        }else if((d >= 23 && m==9) || (d<= 22 && m==10)){
            zodiac="Libra";
        }else if((d >= 23 && m==10) || (d<= 22 && m==11)){
            zodiac="Scorpio";
        }else if((d >= 23 && m==11) || (d<= 21 && m==12)){
            zodiac="Sagittarius";
        }else if((d >= 22 && m==12) || (d<= 20 && m==1)){
            zodiac="Capricorn";
        }else if((d >= 21 && m==1) || (d<= 19 && m==2)){
            zodiac="Aquarius";
        }else if((d >= 20 && m==2) || (d<= 20 && m==3)){
            zodiac="Pisces";
        }else{
            zodiac="Error";
        }
        return zodiac;
    }
}
