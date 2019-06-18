import java.util.*;
import java.util.stream.*;
public class MakeASalad {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Deque<String> vegetablesQueue=new ArrayDeque<String>();
        Arrays.asList(scanner.nextLine().split("\\s+")).stream().forEach(vegetablesQueue::offer);
        Deque<Integer> saladsStack=new ArrayDeque<Integer>();
        Arrays.asList(scanner.nextLine().split("\\s+")).stream().mapToInt(Integer::parseInt).forEach(saladsStack::push);
        int current=
        
        System.out.println();
        if(!saladsStack.isEmpty()){
            saladsStack.stream().forEach(x -> System.out.print(x+" "));
        }
        if(!vegetablesQueue.isEmpty()){
            vegetablesQueue.stream().forEach(x -> System.out.print(x+" "));
        }
    }
    public static int convertVegetableToInt(String val){
        switch(val){
            case "tomato":
                return 80;
            case "carrot":
                return 136;
            case "lettuce":
                return 109;
            case "potato":
                return 215;
        }
        return 0;
    }
  
}