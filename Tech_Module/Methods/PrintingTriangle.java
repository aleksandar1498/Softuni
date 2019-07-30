package methods;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n*2; i++) {
            if(i <= n){
                printLine(1,i);
            }else{
                printLine(1,n*2-i);
            }
        }
    }
    public static void printLine(int start,int end){
        for (int i = start; i <= end; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
