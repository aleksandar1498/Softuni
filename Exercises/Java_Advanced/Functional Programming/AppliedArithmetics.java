package lineardatastructure.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> integers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        String action="";

        while(!"end".equals(action = scanner.nextLine())){
            if(action.equals("print")){
                integers.stream().forEach(x -> System.out.print(x+" "));
                System.out.println();
            }else{
                Function<Integer,Integer> operation=createOperation(action);
                for (int i = 0; i < integers.size(); i++) {
                    integers.set(i,operation.apply(integers.get(i)));
                }
            }

        }
    }

    private static Function<Integer, Integer> createOperation(String action) {
        Function<Integer, Integer> operate=null;
        switch (action){
            case "add":
                operate=x -> x+=1;
                break;
            case "multiply":
                operate=x -> x*2;
                break;
            case "subtract":
                operate=x -> x-1;
                break;

        }
        return operate;
    }

}
