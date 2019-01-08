package com.softuni.arrays;

import java.util.Scanner;

public class SearchFigureMatrix {
    public static double [][] searchFigure(double[][] figure,double range){
        double averageVal=averageMatrix(figure);
        for (int i = 0; i < figure.length; i++) {
            for (int j = 0; j < figure[i].length; j++) {
                if(figure[i][j] > averageVal+range){
                    figure[i][j]=1.0;
                }else{
                    figure[i][j]=0.0;
                }
            }
        }
        return figure;
    }
    public static double averageMatrix(double [][] figure){
        double sum=0;
        for (int i = 0; i < figure.length; i++) {
            for (int j = 0; j < figure[i].length; j++) {
                sum+=figure[i][j];
            }
        }
        return sum/(figure.length*figure[0].length);
    }
    public static void main(String[] args) {
       double [][] matrix= {
               new double[]{1.2, 1.3, 4.5,6.0,2.7},
               new double[]{1.7, 3.3, 4.4,10.5,17.0},
               new double[]{1.1, 4.5, 2.1,25.3,9.2},
               new double[]{1.0,9.5,8.3,2.9,2.1}
       };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.printf("The average is %.2f\n",averageMatrix(matrix));

        double figure[][]=searchFigure(matrix,1.4);
        for (int i = 0; i < figure.length; i++) {
            for (int j = 0; j < figure[i].length; j++) {
                System.out.print(figure[i][j]+" ");
            }
            System.out.println();
        }
    }
}
