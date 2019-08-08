package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class Missions implements Mission {


    private String id;
    private Double rating;
    private Double bounty;
    private boolean completed;
    Missions(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        this.completed = false;
    }
    public void complete(){
        this.completed = true;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }


}
