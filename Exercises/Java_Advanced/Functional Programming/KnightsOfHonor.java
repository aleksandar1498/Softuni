package lineardatastructure.functionalprogramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] names= scanner.nextLine().split(" ");
        Consumer<String> read= name -> System.out.println("Sir "+name);
        for (String name : names) {
            read.accept(name);
        }
    }
}
