package interfaces.races;

import exceptions.DuplicateModelException;
import interfaces.boats.Boat;
import repositories.Repository;

public interface Race {
    void add(Boat boat) throws DuplicateModelException;
    Repository<Boat> getParticipants();
}
