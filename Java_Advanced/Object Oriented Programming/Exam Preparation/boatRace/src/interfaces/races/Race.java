package interfaces.races;

import exceptions.DuplicateModelException;
import exceptions.ParameterArgumentException;
import interfaces.boats.Boat;
import repositories.Repository;

public interface Race {
    void add(Boat boat) throws DuplicateModelException;

    Repository<Boat> getParticipants();

    void setDistance(int distance) throws ParameterArgumentException;

    void setWindSpeed(int windSpeed);

    void setOceanSpeed(int oceanSpeed);

    void setMotorboatsAreAllowed(boolean motorboatsAreAllowed);

    void open();

    void close();

    boolean isOpen();

    boolean isMotorboatsAreAllowed();
}
