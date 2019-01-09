package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] strings= scanner.nextLine().split(" ");
        for (int word = strings.length-1; word >= 0; word--) {
            System.out.print(strings[word]+" ");
        }
    }
}
