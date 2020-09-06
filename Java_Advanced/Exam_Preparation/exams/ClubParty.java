package arena;

import java.util.*;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String> operations=new ArrayDeque<>();
        LinkedHashMap<String, LinkedList<Integer>> halls=new LinkedHashMap<>();
        int maxParticipant=Integer.parseInt(scanner.nextLine());
        for (String o : scanner.nextLine().split(" ")) {
            operations.push(o);
        }
        while(operations.peek() != null){
          String o=operations.pop();
            if(Character.isAlphabetic(o.charAt(0))){
                halls.putIfAbsent(o,new LinkedList<>());

            }else{
                if(!halls.isEmpty()){
                    int newSum=halls.entrySet().stream().findFirst().get().getValue().stream().mapToInt(Integer::intValue).sum()+Integer.parseInt(o);
                    String name=halls.entrySet().stream().findFirst().get().getKey();
                    if(newSum < maxParticipant){
                        halls.get(name).add(Integer.parseInt(o));
                    }else if(newSum == maxParticipant){
                        halls.get(name).add(Integer.parseInt(o));
                        System.out.println(name+" -> "+halls.get(name).toString().replaceAll("[\\[\\]]",""));
                        halls.remove(name);
                    }else{
                        System.out.println(name+" -> "+halls.get(name).toString().replaceAll("[\\[\\]]",""));
                        halls.remove(name);
                        if(!halls.isEmpty()){
                            halls.entrySet().stream().findFirst().get().getValue().add(Integer.parseInt(o));
                        }
                    }
                }
            }
        }
    }
}
