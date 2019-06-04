package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> evenNumbers=Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n%2 == 0)
                .boxed()
                .collect(Collectors.toList());
        if(evenNumbers.size() != 0) {
            System.out.println(evenNumbers.toString().replaceAll("[\\[\\]]", ""));
            evenNumbers.sort(Comparator.naturalOrder());
            System.out.println(evenNumbers.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
