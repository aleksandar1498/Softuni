package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] bounds= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String type=scanner.nextLine();
        Predicate<Integer> validate=createPredicate(type);
        BiFunction<Integer,Integer,Integer[]> array= (a,b) -> {
            Integer [] arr=new Integer[(int)(Math.abs(a-b)+1)];
            int k=0;
            for (int i = a; i <= b; i++) {
                arr[k]=i;
                k++;
            }
            return arr;
        };
        Arrays.stream(array.apply(bounds[0],bounds[1])).filter(validate).forEach(val -> System.out.print(val+" "));
    }
    static Predicate<Integer> createPredicate(String type){
        Predicate<Integer> predicate=null;
        switch (type){
            case "odd":
                predicate = val -> val % 2 != 0;
                break;
            case "even":
                predicate= val -> val %2 == 0;
                break;
        }
        return predicate;
    }
}
