package panzer.core;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Vehicle;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private Map<String, Vehicle> vehicles;
    private BattleOperator battleOperator;

    public ManagerImpl() {
        this.battleOperator = new PanzerBattleOperator();
        this.vehicles = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        return null;
    }

    @Override
    public String addPart(List<String> arguments) {
        return null;
    }

    @Override
    public String inspect(List<String> arguments) {
        return null;
    }

    @Override
    public String battle(List<String> arguments) {
        return null;
    }

    @Override
    public String terminate(List<String> arguments) {
        return null;
    }
}
