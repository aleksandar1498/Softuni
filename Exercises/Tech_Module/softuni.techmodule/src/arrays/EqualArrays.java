package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] arrayOne= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int [] arrayTwo=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < arrayOne.length; i++) {

                if(arrayOne[i] != arrayTwo[i]){
                    System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                return;
                }

        }
        int sum=0;
        for(int a:arrayOne){
            sum+=a;
        }
        System.out.printf("Arrays are identical. Sum: %d",sum);
    }
}
