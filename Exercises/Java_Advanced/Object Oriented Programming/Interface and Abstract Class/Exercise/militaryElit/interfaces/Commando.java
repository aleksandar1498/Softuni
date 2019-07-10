package militaryElit.interfaces;

import militaryElit.common.Mission;

import java.util.Collection;

public interface Commando{
    void completeMission(Mission mission);
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
