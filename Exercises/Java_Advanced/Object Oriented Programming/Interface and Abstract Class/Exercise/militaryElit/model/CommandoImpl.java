package militaryElit.model;

import militaryElit.common.Mission;
import militaryElit.enums.Corps;
import militaryElit.interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void completeMission(Mission mission) {

        if (this.missions.stream().anyMatch(m -> m.getCodeName().equals(mission.getCodeName()))) {
            missions.get(missions.indexOf(mission)).changeState();
        }
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append(String.format("Corps: %s",super.getCorps().name()));
        builder.append(System.lineSeparator());
        builder.append("Missions:");
        for (Mission mission : this.missions) {
            builder.append(System.lineSeparator());
            builder.append(mission);
        }
        return builder.toString();
    }
}
