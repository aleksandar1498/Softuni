import java.util.*;
import java.util.stream.*;
public class TheSwanStation {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> result=new ArrayList<>();
        ArrayDeque<Integer> theNumbersQueue=new ArrayDeque<>();
        ArrayDeque<Integer> integersQueue=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(theNumbersQueue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(integersQueue::offer);


        while(result.size() < 6){
            int nStackVal=theNumbersQueue.peek();
            int nQueueVal=integersQueue.poll();
            if(nQueueVal%nStackVal == 0){
                theNumbersQueue.poll();
                result.add(nQueueVal);
            }else{
                integersQueue.offer(nQueueVal+1);
            }
            
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]",""));
        
    }
}