package com.softuni;

import java.util.GregorianCalendar;

public class MonthInTheYear_ENUMERATION {
    enum year{JANUARY(31),FABRUARY(28),MARCH(31),APRIL(30),MAY(31),JUNE(30),JULY(31),AUGUST(31),SEPTEMBER(30),OCTOBER(31),NOVEMBER(30),DECEMBER(31);
    private int d=0;
    private year(int days){
        this.d=days;
    }
    public int getDays(){
        return d;
    }
    };
    enum leapYear{JANUARY(31),FABRUARY(29),MARCH(31),APRIL(30),MAY(31),JUNE(30),JULY(31),AUGUST(31),SEPTEMBER(30),OCTOBER(31),NOVEMBER(30),DECEMBER(31);
        private int d=0;
        private leapYear(int days){
            this.d=days;
        }
        public int getDays(){
            return d;
        }
    };

    public static void main(String[] args) {

        for(year m:year.values()){
            System.out.println(m+" "+m.getDays());
        }

    }
}
