package lineardatastructure.functionalprogramming;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        BiPredicate<Integer,Integer> predicate= (a,b) -> a%b == 0;
        Set<Integer> divisors=new TreeSet<>(Comparator.reverseOrder()){{
            addAll(Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        }};
        int limit=divisors.iterator().next();
        for (int i = limit; i <=  n; i+=limit) {
            boolean divisibleByAll=true;
            Iterator<Integer> it=divisors.iterator();
            while(it.hasNext()){
                if(!predicate.test(i,it.next())){
                    divisibleByAll=false;
                }
            }
            if(divisibleByAll){
                System.out.print(i+" ");
            }
        }

    }
}
