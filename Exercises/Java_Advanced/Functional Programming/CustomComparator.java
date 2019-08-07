package lineardatastructure.functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> arr=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Comparator<Integer> newComparator=(a,b) -> {
            boolean firstIsEven=a%2 == 0;
            boolean secondIsEven=b%2 == 0;
            if(firstIsEven && !secondIsEven){
                return -1;
            }else if(!firstIsEven && secondIsEven){
                return 1;
            }else{
                return a-b;
            }
        };

        Collections.sort(arr,newComparator);
        arr.forEach(x -> System.out.print(x+" "));
    }
}
