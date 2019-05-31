package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String [] names=scanner.nextLine().split(" ");

        Predicate<String> validate=name -> name.length() <= n;
        Function<String,Boolean> filterNames=name -> validate.test(name);
        Arrays.stream(names)
                .filter(filterNames::apply)
                .forEach(System.out::println);
    }
}
