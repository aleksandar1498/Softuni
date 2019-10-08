package com.training;

import java.util.*;

public class secondNature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> eternalFlower = new ArrayList<>();
        Deque<Integer> flowersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(flowersQueue::add);
        Deque<Integer> bucketStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(bucketStack::add);

       while (!flowersQueue.isEmpty() && !bucketStack.isEmpty()){
            int currentFlower = flowersQueue.peek();
            int currentBucket = bucketStack.peek();
            int difference = currentFlower - currentBucket;
            if(difference == 0){
                eternalFlower.add(currentFlower);
                bucketStack.pop();
            }else if(difference < 0){
                flowersQueue.poll();
                if(bucketStack.size() > 1){
                    bucketStack.pop();
                    bucketStack.push(bucketStack.pop() + Math.abs(difference));
                }else if(bucketStack.size() == 1){

                    bucketStack.push(bucketStack.pop() + Math.abs(difference));
                }

            }
            if(difference > 0){
                bucketStack.pop();
                flowersQueue.poll();
                flowersQueue.offer(difference);
            }
        }
       if(bucketStack.size() > 0){
           System.out.println(bucketStack.toString().replaceAll("[\\[\\],]",""));
       }else{
           System.out.println(flowersQueue.toString().replaceAll("[\\[\\],]",""));

       }
        System.out.println((eternalFlower.size() > 0)?eternalFlower.toString().replaceAll("[\\[\\],]",""):"None");
    }
}
