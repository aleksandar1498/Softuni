package exams;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agency {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String> idNumbers=new ArrayDeque<>();
        ArrayDeque<String> agents=new ArrayDeque<>();
        String[] idData=scanner.nextLine().split(" ");
        for (String data : idData){
            idNumbers.push(data);
        }
        String[] agentData=scanner.nextLine().split(" ");
        for(String data:agentData){
            agents.offer(data);
        }
        String[] action=scanner.nextLine().split(" ");
        while(!action[0].equals("stop")){
            switch (action[0]){
                case "add-ID":
                    idNumbers.push(action[1]);
                    break;
                case "add-agent":
                    agents.offer(action[1]);
                    break;
                case "remove-ID":
                    System.out.println(idNumbers.peek()+" has been removed.");
                    idNumbers.pop();
                    break;
                case "remove-agent":
                    System.out.println(agents.peekLast()+" has left the queue.");
                    agents.removeLast();
                    break;
                case "sort-ID":

                    idNumbers=idNumbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayDeque::new));



                    break;
            }
            action=scanner.nextLine().split(" ");
        }
        while(!idNumbers.isEmpty() && !agents.isEmpty()) {
            String agent = agents.poll();
            String ID = idNumbers.pop();

            System.out.println(agent + " takes ID number: " + ID);


        }
        if(idNumbers.isEmpty() && !agents.isEmpty()){
            agents.forEach(agente -> System.out.println(agente+" does not have an ID."));
        }
        if(agents.isEmpty() && !idNumbers.isEmpty()){
            System.out.println("No more agents left.");

            idNumbers.forEach(id-> System.out.println("ID number: "+id));
        }




    }
}
