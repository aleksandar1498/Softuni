package callofduty.models;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

import java.util.Iterator;

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
        Iterator<Mission> iterator = super.getAssignedMissions().values().iterator();
        while (iterator.hasNext()){
            Mission current = iterator.next();
            super.increaseRating(current.getRating());
            this.increaseBounty(current.getBounty());
            super.getCompletedMissions().put(current.getId(),current);
            iterator.remove();
        }
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("Bounty Earned: $%.2f", this.getBounty());
    }
}
