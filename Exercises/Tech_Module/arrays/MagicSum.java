package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] data= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < data.length; i++) {
            for (int j = i+1; j < data.length; j++) {
                if(i != j){
                    if((data[i]+data[j]) == n){
                        System.out.println(data[i]+" "+data[j]);
                    }
                }
            }
        }
    }
}
