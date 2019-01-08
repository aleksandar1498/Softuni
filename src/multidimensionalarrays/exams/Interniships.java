package multidimensionalarrays.exams;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Interniships {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> candidatesQue = new ArrayDeque<>();
        ArrayDeque<String> problemsSt = new ArrayDeque<>();
        int numProblems=Integer.parseInt(scanner.nextLine());

        int numOfCandidates = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numProblems; i++) {
            String name=scanner.nextLine();
            problemsSt.push(name);
        }
        for (int i = 0; i < numOfCandidates; i++) {
            String name = scanner.nextLine();
            if(name.matches("[A-Z][a-z]+ [A-Z][a-z]+")){
                candidatesQue.offer(name);
            }
        }

        while(!candidatesQue.isEmpty() && !problemsSt.isEmpty()){

            String currentCandidate=candidatesQue.poll();
            String currentP=problemsSt.pop();
            int sumProblem=0;
            for(char c:currentP.toCharArray()){
                sumProblem+=(int)c;
            }
            int sumCan=0;
            for(char c:currentCandidate.toCharArray()){
                sumCan+=(int)c;
            }
            if(sumCan > sumProblem){
                System.out.println(currentCandidate+" solved "+currentP+".");
                candidatesQue.offer(currentCandidate);
            }else{
                System.out.println(currentCandidate+" failed "+currentP+".");
                problemsSt.addLast(currentP);
            }

            if(candidatesQue.size() == 1){
                System.out.println(candidatesQue.poll()+" gets the job!");
           return;
            }

        }

        System.out.println(String.join(",",candidatesQue));


    }


}
