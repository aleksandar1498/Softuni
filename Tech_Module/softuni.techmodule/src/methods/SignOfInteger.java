package methods;

import java.util.Scanner;

public class SignOfInteger {
    public static void defineSign(int val){
        if(val > 0){
            System.out.printf("The number %d is positive.",val);
        }else{
            System.out.printf("The number %d is negative.",val);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        defineSign(n);
    }
}
