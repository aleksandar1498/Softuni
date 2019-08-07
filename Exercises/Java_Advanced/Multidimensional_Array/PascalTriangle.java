package multidimensionalarrays;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        int[][] row = new int[n][];
row[0]=new int[1];
row[0][0]=1;
        for (int i = 1; i < row.length; i++) {
            row[i] = new int[i + 1];

            for (int j = 0; j < row[i].length; j++) {
                if((j==0) || (j  == row[i].length-1)){
                    row[i][j] = 1;

                }else{
                    row[i][j] = row[i - 1][j - 1] + row[i - 1][j];

                }

            }
        }
        for (int i = 0; i < row.length; i++) {
            printSpace(" ",row.length-i);
            for (int j = 0; j < row[i].length; j++) {
                System.out.print(row[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printSpace(String sym,int n){
        for (int i = 0; i < n; i++) {
            System.out.print(sym);
        }
    }
}
