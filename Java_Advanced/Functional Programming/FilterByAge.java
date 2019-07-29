package lineardatastructure.functionalprogramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputToken = scanner.nextLine().split(", ");
            people.put(inputToken[0], Integer.parseInt(inputToken[1]));
        }
        String condition = scanner.nextLine();
        int ageDelimiter = Integer.parseInt(scanner.nextLine());
        String printerCondition = scanner.nextLine();
        Predicate<Integer> tester=createTester(condition,ageDelimiter);
        Consumer<Map.Entry<String,Integer>> printer=createPrinter(printerCondition);
        for (Map.Entry<String,Integer> person:
             people.entrySet()) {
            if(tester.test(person.getValue())){
                printer.accept(person);
            }
        }

    }

    static Predicate<Integer> createTester(String condition, Integer age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger":
                tester = y -> (y <= age);
                break;
            case "older":
                tester = y -> (y >= age);
                break;
        }
        return tester;
    }

    static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String,Integer>> printer=null;
        switch (format) {
            case "name":
                printer = person -> System.out.println(person.getKey());
                break;
            case "age":
                printer = person -> System.out.println(person.getValue());
                break;
            default:
                printer = person -> System.out.println(person.getKey()+" - "+person.getValue());

                break;
        }
        return printer;
    }
}
