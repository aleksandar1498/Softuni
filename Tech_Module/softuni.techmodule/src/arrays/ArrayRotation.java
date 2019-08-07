package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] values= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int rotations=Integer.parseInt(scanner.nextLine());

        for (int rotation = 0; rotation < rotations; rotation++) {
            int temp=values[0];
            for (int i = 0; i < values.length-1; i++) {

                values[i]=values[i+1];

            }
            values[values.length-1]=temp;

        }
        for(int val:values){
            System.out.print(val+" ");
        }
    }
}
