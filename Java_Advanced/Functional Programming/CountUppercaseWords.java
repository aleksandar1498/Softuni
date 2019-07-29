package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Predicate<String> startsWithUppercase = word -> Character.isUpperCase(word.charAt(0));
        String text=scanner.nextLine();
        List<String> uppercaseWords =Arrays.stream(text.split(" "))
                .filter(startsWithUppercase)
                .collect(Collectors.toList());
        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);
    }
}
