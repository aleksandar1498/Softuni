package interfaces.boats;

import interfaces.races.Race;

public interface Boat {
    String getModel();
    double getSpeed(Race race);
    double getWeight();

}
