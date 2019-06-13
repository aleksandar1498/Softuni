import java.util.*;
import java.util.stream.*;
public class SecondNature {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> flowersQueue=new ArrayDeque<>();
        ArrayDeque<Integer> bucketsStack=new ArrayDeque<>();
        List<Integer> secondNatureFlowers=new ArrayList<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(flowersQueue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(bucketsStack::push);
        while(!flowersQueue.isEmpty() && !bucketsStack.isEmpty()){
            if(bucketsStack.peek() > flowersQueue.peek()){
                // if the bucket contains more water then needed , if it is the only bucket it remains the same, in the other case, his water is passed to the following bucket
                bucketsStack.push(bucketsStack.pop()-flowersQueue.poll());
               // bucketsStack.peek()=bucketsStack.peek()-flowersQueue.poll();
                if(bucketsStack.size() > 1){
                    int valToBePassed=bucketsStack.pop();
                    bucketsStack.push(bucketsStack.pop()+valToBePassed);
                }
            }else if(bucketsStack.peek() < flowersQueue.peek()){
                flowersQueue.offer(flowersQueue.poll()-bucketsStack.pop());
                //flowersQueue.peek()=flowersQueue.peek()-bucketsStack.pop();
            }else{
                secondNatureFlowers.add(flowersQueue.poll());
                bucketsStack.pop();
            }
        }
        if(!flowersQueue.isEmpty()){
            System.out.println(flowersQueue.toString().replaceAll("[\\[\\],]",""));
        }else if(!bucketsStack.isEmpty()){
            while(!bucketsStack.isEmpty()){
                System.out.printf("%d ",bucketsStack.pop());
            }
            System.out.println();
           // System.out.println(bucketsStack.toString().replaceAll("[\\[\\],]",""));
        }
        if(secondNatureFlowers.size() > 0){
            System.out.println(secondNatureFlowers.toString().replaceAll("[\\[\\],]",""));
        }else{
            System.out.println("None");
        }
        
    }
}