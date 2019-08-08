package callofduty.core;

import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissionControlTest {
    private MissionControl missionControl;

    @Before
    public void init() {
        this.missionControl = new MissionControlImpl();
    }

    @Test
    public void generateMissionShouldShrinkTheMissionIdIfItIsLongerThenAllowed() {
        Mission mission = this.missionControl.generateMission("Aleksandar", 2.0, 2.0);
        assertEquals("Aleksand", mission.getId());
    }

    @Test
    public void generateMissionShouldNotShrinkTheMissionIdIfItHisLengthIsLessThenLimit() {
        Mission mission = this.missionControl.generateMission("Alex", 2.0, 2.0);
        assertEquals("Alex", mission.getId());
    }

    @Test
    public void generateMissionShouldSetTheRatingToTheMinimumIfItISLessThenIt() {
        Mission mission = this.missionControl.generateMission("Alex", -2.0, 2.0);
        assertEquals(0, Double.compare(0D, mission.getRating()));
    }

    @Test
    public void generateMissionShouldSetTheRatingToTheMaxIfItIsHigherThenIt() {
        Mission mission = this.missionControl.generateMission("Alex", 102.0, 2.0);
        System.out.println(mission.getRating());
        // the expected rating is 75 , because the mission setter reduces it value
        assertEquals(0, Double.compare(75, mission.getRating()));
    }

    @Test
    public void generateMissionShouldSetTheExpectedRating() {
        Mission mission = this.missionControl.generateMission("Alex", 50.0, 2.0);
        System.out.println(mission.getRating());
        // the expected rating is 75 , because the mission setter reduces it value
        assertEquals(0, Double.compare(37.5, mission.getRating()));
    }

    @Test
    public void generateMissionShouldSetTheBountyToTheMinimumIfItISLessThenIt() {
        Mission mission = this.missionControl.generateMission("Alex", 2.0, -22.0);
        assertEquals(0, Double.compare(0D, mission.getBounty()));
    }

    @Test
    public void generateMissionShouldSetTheBountyToTheMaxIfItIsHigherThenIt() {
        Mission mission = this.missionControl.generateMission("Alex", 102.0, 1000001.00);
        System.out.println(mission.getBounty());
        // the expected rating is 75 , because the mission setter reduces it value
        assertEquals(0, Double.compare(100000D * 1.25, mission.getBounty()));
    }

    @Test
    public void generateMissionShouldSetTheExpectedBounty() {
        Mission mission = this.missionControl.generateMission("Alex", 50.0, 100.0);
        System.out.println(mission.getBounty());
        // the expected rating is 75 , because the mission setter reduces it value
        assertEquals(0, Double.compare(100 * 1.25, mission.getBounty()));
    }
    @Test
    public void generateMissionShouldGenerateEscortMissionTheFirstTime(){
        assertEquals(EscortMission.class,this.missionControl.generateMission("alex",20.0,20.0).getClass());
    }
    @Test
    public void generateMissionShouldGenerateHuntMissionTheSecondTime(){
        this.missionControl.generateMission("alex",12.2,21.2);
        assertEquals(HuntMission.class,this.missionControl.generateMission("alex",20.0,20.0).getClass());
    }
    @Test
    public void generateMissionShouldSurveillanceMissionTheThirdTime(){
        this.missionControl.generateMission("alex",12.2,21.2);
        this.missionControl.generateMission("alex",12.2,21.2);
        assertEquals(SurveillanceMission.class,this.missionControl.generateMission("alex",20.0,20.0).getClass());
    }
    @Test
    public void generateMissionShouldStartFromTheBeginningAtTheFourthTime(){
        this.missionControl.generateMission("alex",12.2,21.2);
        this.missionControl.generateMission("alex",12.2,21.2);
        this.missionControl.generateMission("alex",12.2,21.2);
        assertEquals(EscortMission.class,this.missionControl.generateMission("alex",20.0,20.0).getClass());
    }
}
