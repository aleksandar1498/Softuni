package callofduty.models;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

public class MasterAgent extends Agents implements BountyAgent {
    private double bounty;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.bounty = 0;
    }

    private void increaseBounty(double n) {
        this.bounty += n;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public void completeMissions() {
        for (Mission mission : super.getAssignedMissions().values()) {
            super.increaseRating(mission.getRating());
            this.increaseBounty(mission.getBounty());
            super.getCompletedMissions().put(mission.getId(), mission);
            super.getAssignedMissions().remove(mission.getId());
        }
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("Bounty Earned: $%.2f", this.getBounty());
    }
}
