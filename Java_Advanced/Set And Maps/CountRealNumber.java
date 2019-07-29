import java.util.*;
import java.util.regex.*;
public class CountRealNumbers{
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       final Map<Double,Integer> occurrences=new LinkedHashMap<>();
       Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach(val -> {
          if(occurrences.containsKey(val)){
              occurrences.put(val,occurrences.get(val)+1);
          }else{
              occurrences.put(val,1);
          } 
       });
       occurrences.entrySet().stream().forEach(x -> System.out.printf("%.1f -> %d%n",x.getKey(),x.getValue()));
     
     
    }
}