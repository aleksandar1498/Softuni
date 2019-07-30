package repositories;

import interfaces.boats.Boat;
import interfaces.engines.BoatEngine;

public class Database {
    private Repository<BoatEngine> boatEngineRepository;
    private Repository<Boat> boatsRepository;

    public Database(Repository<BoatEngine> boatEngineRepository, Repository<Boat> boatsRepository) {
        this.boatEngineRepository = boatEngineRepository;
        this.boatsRepository = boatsRepository;
    }

    public Repository<BoatEngine> getBoatEngineRepository() {
        return boatEngineRepository;
    }

    public Repository<Boat> getBoatsRepository() {
        return boatsRepository;
    }
}
