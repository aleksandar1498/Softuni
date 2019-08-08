package callofduty.domain.missions;

public class EscortMission extends Missions {
    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating * .75, bounty * 1.25);
    }
}
