package exams;

import java.util.*;

public class Agents_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // match for the agents .*[0][\d]{2}
        //Registration
        HashMap<String, Double> missions = new HashMap<>();
        HashMap<String, LinkedHashMap<String, Double>> agents = new HashMap<>();
        String action = scanner.nextLine();
        while (!action.equals("registration")) {
            String[] data = action.split(":");
            if (action.charAt(0) == '#') {
                missions.putIfAbsent(data[0], Double.valueOf(data[1]));
            }
            if (action.matches(".*[0][\\d]{2}")) {
                agents.putIfAbsent(data[0], new LinkedHashMap<>());
            }
            action = scanner.nextLine();
        }
        //Operation
        String[] secondAction=scanner.nextLine().split("->");
        while(!secondAction[0].equals("operate")){
            switch (secondAction[0]){
                case "assign":
                    if(agents.containsKey(secondAction[1])){

                        if(!agents.get(secondAction[1]).containsKey(secondAction[2]) && missions.containsKey(secondAction[2])){
                            agents.get(secondAction[1]).put(secondAction[2],missions.get(secondAction[2]));
                        }
                    }
                    break;
                case "abort":

                    for(Map.Entry<String,LinkedHashMap<String,Double>> agent: agents.entrySet()){

                       if(agent.getValue().containsKey(secondAction[1])){
                           agent.getValue().remove(secondAction[1]);
                       }

                    }


                    break;
                case "change":
                    if(agents.containsKey(secondAction[1]) && agents.containsKey(secondAction[2])){
                      Map<String,Double> missionAgent1=new LinkedHashMap<>(agents.get(secondAction[1]));
                      Map<String,Double> missionAgent2=new LinkedHashMap<>(agents.get(secondAction[2]));
                      agents.get(secondAction[1]).clear();
                      agents.get(secondAction[2]).clear();
                      agents.get(secondAction[1]).putAll(missionAgent2);
                      agents.get(secondAction[2]).putAll(missionAgent1);
                    }

                    break;
            }
            secondAction=scanner.nextLine().split("->");
        }
           agents.entrySet().stream().forEach(x ->{


                       System.out.println(x.getKey()+"\n MISSIONS ");
                       x.getValue().entrySet().stream().forEach(mission -> {

                           System.out.println(mission.getKey()+" val "+mission.getValue());
                       });

                  });
     /*   System.out.println("Missions");
        missions.entrySet().forEach(x-> System.out.printf("%s\n",x.getKey()));
        System.out.println("Agents");
        agents.entrySet().forEach(agent -> System.out.println(agent.getKey()));*/
    }
}
