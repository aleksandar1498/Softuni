package callofduty.models;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Agents implements Agent {

    private String id;
    private String name;
    private Double rating;
    private Map<String,Mission> assignedMissions;
    private Map<String,Mission> completedMissions;


     Agents(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.assignedMissions = new LinkedHashMap<>();
        this.completedMissions = new LinkedHashMap<>();
    }


    @Override
    public void acceptMission(Mission mission) {
        this.assignedMissions.put(mission.getId(),mission);
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }
    protected void increaseRating(double n){
        this.rating+=n;
    }

    public Map<String,Mission> getAssignedMissions() {
        return this.assignedMissions;
    }
    public Map<String,Mission> getCompletedMissions() {
        return this.completedMissions;
    }
    @Override
    public String toString() {

         return String.format("%s Agent – %s", this.getClass().getSimpleName(), this.getName()) +
                System.lineSeparator() +
                String.format("Personal Code: %s", this.getId()) +
                System.lineSeparator() +
                String.format("Assigned Missions: %d", this.getAssignedMissions().size()) +
                System.lineSeparator() +
                String.format("Completed Missions: %d", this.getCompletedMissions().size()) +
                System.lineSeparator() +
                String.format("Rating: %.2f", this.getRating());
    }
}
