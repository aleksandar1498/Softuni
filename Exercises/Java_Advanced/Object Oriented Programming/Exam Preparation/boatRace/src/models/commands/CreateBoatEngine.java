package models.commands;

import annotations.Inject;
import factories.BoatFactory;
import factories.EngineFactory;
import interfaces.boats.Boat;
import interfaces.engines.BoatEngine;
import repositories.Repository;

public class CreateBoatEngine extends Command {
    @Inject
    EngineFactory engineFactory;
    @Inject
    Repository<BoatEngine> boatEngineRepository;

    protected CreateBoatEngine(String[] data) {
        super(data);
    }

    private EngineFactory getEngineFactory() {
        return engineFactory;
    }

    private Repository<BoatEngine> getBoatEngineRepository() {
        return boatEngineRepository;
    }

    @Override
    public String execute() {
        BoatEngine boat = this.getEngineFactory().build(super.getData());
        this.boatEngineRepository.add(boat.getModel(),boat);
        return "";
    }
}
