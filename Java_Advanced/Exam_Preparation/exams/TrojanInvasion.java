package exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Deque<Integer> trojansStack=new ArrayDeque<>();
        Deque<Integer> spartansQueue=new ArrayDeque<>();
        int numberOfWaves=Integer.parseInt(scanner.nextLine());
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(spartansQueue::offer);
        for (int i = 0; i < numberOfWaves; i++) {


            Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(trojansStack::push);
            if((i+1)%3 == 0){
                Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(spartansQueue::offer);
            }

            while(!trojansStack.isEmpty() && !spartansQueue.isEmpty()){
                int trojanWarrior=trojansStack.peek();
                int spartansPlate=spartansQueue.peek();
                int rest=spartansPlate-trojanWarrior;
                if(rest < 0){
                    spartansQueue.pop();
                    trojansStack.push(trojansStack.pop()-spartansPlate);
                }else if(rest > 0){
                    trojansStack.pop();
                    spartansQueue.addFirst(spartansQueue.poll()-trojanWarrior);
                }else{
                    trojansStack.pop();
                    spartansQueue.poll();
                }
            }
            if(spartansQueue.isEmpty()){
                System.out.println("The Trojans successfully destroyed the Spartan defense.");
                System.out.printf("Warriors left: %s",trojansStack.toString().replaceAll("[\\[\\]]",""));
                return;
            }
        }
        System.out.println("The Spartans successfully repulsed the Trojan attack.\n" +
                "Plates left: "+spartansQueue.toString().replaceAll("[\\[\\]]",""));

    }
}
