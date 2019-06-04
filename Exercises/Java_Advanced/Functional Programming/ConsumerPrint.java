package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> names= Arrays.asList(scanner.nextLine().split(" "));
        Consumer<String> read=name -> System.out.println(name);
        for (String name : names) {
            read.accept(name);
        }
    }
}
