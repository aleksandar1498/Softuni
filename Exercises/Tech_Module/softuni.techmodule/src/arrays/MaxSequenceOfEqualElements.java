package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] numbers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxSequence=Integer.MIN_VALUE;
        int n=0;
       mainFor: for (int i = 0; i < numbers.length-1; i++) {
            int equalNumber=1;
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] == numbers[j]){
if(equalNumber == numbers.length-1){
    n=numbers[i];
    maxSequence=equalNumber;
    break mainFor;
}else{
    equalNumber++;
}

                }else{
                    if(equalNumber > maxSequence){
                        n=numbers[i];
                        maxSequence=equalNumber;
                    }
                    break ;
                }
            }
        }
        for (int i = 0; i < maxSequence; i++) {
            System.out.print(n+" ");
        }

    }
}
