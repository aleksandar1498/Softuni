package callofduty.domain.missions;

public class SurveillanceMission extends Missions {
    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating * .25, bounty * 1.5);
    }
}
