package strategypattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Set<Person> firstSet=new TreeSet<>(new FirstCustomComparator());
        Set<Person> secondSet=new TreeSet<>(new SecondCustomComparator());

        for (int i = 0; i < n; i++) {
            String [] token=scanner.nextLine().split(" ");
             firstSet.add(new Person(token[0],Integer.parseInt(token[1])));
            secondSet.add(new Person(token[0],Integer.parseInt(token[1])));

        }
        firstSet.forEach(p -> System.out.println(p.toString()));
        secondSet.forEach(p -> System.out.println(p.toString()));
    }
}
