package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class VAT {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        UnaryOperator<Double> addVat= val -> val*1.2;
        List<Double> doubles = Arrays.asList(scanner.nextLine().split(", ")).stream().mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        for(Double val : doubles){
            System.out.printf("%.2f%n",addVat.apply(val));
        }
    }
}
