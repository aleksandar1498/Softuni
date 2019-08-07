package callofduty.models;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.Iterator;

public class NoviceAgent extends Agents {
    public NoviceAgent(String id, String name) {
        super(id, name, 0.0);
    }
    @Override
    public void completeMissions() {
        Iterator<Mission> iterator = super.getAssignedMissions().values().iterator();
        while (iterator.hasNext()){
            Mission current = iterator.next();
            super.increaseRating(current.getRating());
            super.getCompletedMissions().put(current.getId(),current);
            iterator.remove();
        }
        /*for (Mission mission : super.getAssignedMissions().values().) {
            super.increaseRating(mission.getRating());
            super.getCompletedMissions().put(mission.getId(),mission);
            super.getAssignedMissions().remove(mission.getId());
        }*/

    }


}
