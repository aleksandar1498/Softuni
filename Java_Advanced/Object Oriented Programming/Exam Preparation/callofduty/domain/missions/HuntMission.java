package callofduty.domain.missions;

public class HuntMission extends Missions {
    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating * 1.5, bounty * 2);
    }
}
