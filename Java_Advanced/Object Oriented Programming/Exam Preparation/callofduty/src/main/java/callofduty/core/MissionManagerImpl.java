package callofduty.core;

import callofduty.interfaces.*;
import callofduty.models.Agents;
import callofduty.models.MasterAgent;
import callofduty.models.NoviceAgent;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {
    private Map<String, Agent> agents;
    private MissionControl missionControl;

    public MissionManagerImpl() {
        this.agents = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(0);
        String name = arguments.get(1);
        this.agents.put(id, new NoviceAgent(id, name));
        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRating = Double.parseDouble(arguments.get(2));
        Double missionBounty = Double.parseDouble(arguments.get(3));
        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);

        this.agents.get(agentId).acceptMission(mission);
        return String.format("Assigned %s - %s to Agent - %s", mission.getClass().getSimpleName().replaceAll("Mission"," Mission"), missionId, this.agents.get(agentId).getName());
    }

    @Override
    public String complete(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        String agentId = arguments.get(0);
        this.agents.get(agentId).completeMissions();
        Agent agent = this.agents.get(agentId);
        Field missions = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
        missions.setAccessible(true);
        Map<String, Mission> completedMissions = (Map<String, Mission>) missions.get(agent);
        if (completedMissions.size() >= 3 && agent.getClass().getSimpleName().equals("NoviceAgent")) {
            // replace the novice agent with the master agent and pass the value of the completed missions
            Agent newAgent = new MasterAgent(agentId, agent.getName(), agent.getRating());
            Field newAgentCompletedField = newAgent.getClass().getSuperclass().getDeclaredField("completedMissions");
            newAgentCompletedField.setAccessible(true);
            newAgentCompletedField.set(newAgent, completedMissions);
            this.agents.put(agentId, newAgent);
        }
        return String.format("Agent - %s:%s has completed all assigned missions.", agent.getName(), agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        final String id = arguments.get(0);
        String status = "";
        Mission assignedMission = this.agents.values().stream().flatMap(a -> {
            Map<String, Mission> assigned = null;
            try {
                Field field = a.getClass().getSuperclass().getDeclaredField("assignedMissions");
                field.setAccessible(true);
                assigned = (Map<String, Mission>) field.get(a);

            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            return assigned.values().stream();
        }).filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        Mission completedMission = this.agents.values().stream().flatMap(a -> {
            Map<String, Mission> completed = null;
            try {
                Field field = a.getClass().getSuperclass().getDeclaredField("completedMissions");
                field.setAccessible(true);
                completed = (Map<String, Mission>) field.get(a);

            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            return completed.values().stream();
        }).filter( x -> x.getId().equals(id)).findFirst().orElse(null);
        if(this.agents.containsKey(id)){
            status = this.agents.get(id).toString();
        }else if(assignedMission != null){
            status = String.format("%s Mission - %s",assignedMission.getClass().getSimpleName().replaceAll("Mission"," Mission"), assignedMission.getId()) +
                    System.lineSeparator() +
                    "Status: Open" +
                    System.lineSeparator() +
                    String.format("Rating: %.2f", assignedMission.getRating()) +
                    System.lineSeparator() +
                    String.format("Bounty: %.2f", assignedMission.getBounty());

        }else if(completedMission != null){
            status = String.format("%s - %s",completedMission.getClass().getSimpleName().replaceAll("Mission"," Mission"), completedMission.getId()) +
                    System.lineSeparator() +
                    "Status: Completed" +
                    System.lineSeparator() +
                    String.format("Rating: %.2f", completedMission.getRating()) +
                    System.lineSeparator() +
                    String.format("Bounty: %.2f", completedMission.getBounty());
        }
        return status;
    }

    @Override
    public String over(List<String> arguments) {
        StringBuilder builder = new StringBuilder();
        long totAssigned = this.agents.values().stream().flatMap(a -> {
            Map<String, Mission> assigned = null;
            try {
                Field assignedMiss = a.getClass().getSuperclass().getDeclaredField("assignedMissions") ;
                assignedMiss.setAccessible(true);
                assigned = (Map<String, Mission>) assignedMiss.get(a);

            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            return assigned.values().stream();
        }).count();
        long totCompleted = this.agents.values().stream().flatMap(a -> {
            Map<String, Mission> completed = null;
            try {
                Field compMiss = a.getClass().getSuperclass().getDeclaredField("completedMissions") ;
                compMiss.setAccessible(true);
                completed = (Map<String, Mission>) compMiss.get(a);

            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            return completed.values().stream();
        }).count();
        Double totalRatingGiven = this.agents.values().stream().mapToDouble(Rateable::getRating).sum();
        Double totalBountyGiven = this.agents.values().stream().mapToDouble(a -> {
            if(a.getClass().getSimpleName().equals("MasterAgent")){
                return ((MasterAgent)a).getBounty();
            }
            return 0;
        }).sum();
        builder.append(String.format("Novice Agents: %d",this.agents.values().stream().filter(x -> x.getClass().getSimpleName().equals("NoviceAgent")).count()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Master Agents: %d",this.agents.values().stream().filter(x -> x.getClass().getSimpleName().equals("MasterAgent")).count()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Assigned Missions: %d",totAssigned+totCompleted));
        builder.append(System.lineSeparator());
        builder.append(String.format("Completed Missions: %d",totCompleted));
        builder.append(System.lineSeparator());
        builder.append(String.format("Total Rating Given: %.2f",totalRatingGiven));
        builder.append(System.lineSeparator());
        builder.append(String.format("Total Bounty Given: $%.2f",totalBountyGiven));

        return builder.toString();
    }
}
