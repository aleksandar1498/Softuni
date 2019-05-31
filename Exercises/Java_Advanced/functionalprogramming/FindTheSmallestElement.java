package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> integerList= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Function<List<Integer>,Integer> findIndexOfSmallest=num -> {
            int smallest=Integer.MAX_VALUE;
            int index=-1;
            for (int i = 0; i < num.size(); i++) {
                if(num.get(i) <= smallest){
                    smallest=num.get(i);
                    index=i;
                }
            }
            return index;
        };
        System.out.println(findIndexOfSmallest.apply(integerList));
    }
}
