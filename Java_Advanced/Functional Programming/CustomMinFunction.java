package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[],Integer> min=x -> (Integer)Arrays.stream(x).min().getAsInt();
        System.out.println(min.apply(arr));
    }
}
