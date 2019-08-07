package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        for (int i = 0; i < n; i++) {
            int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();


            if (i % 2 == 0) {
                arrayOne[i] = a[0];
                arrayTwo[i] = a[1];
            } else if (i % 2 != 0) {
                arrayOne[i] = a[1];
                arrayTwo[i] = a[0];
            }
        }
        for (int valA : arrayOne) {
            System.out.print(valA + " ");
        }
        System.out.println();
        for (int valB : arrayTwo) {
            System.out.print(valB + " ");
        }
    }
}
