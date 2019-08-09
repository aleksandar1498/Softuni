package panzer.core;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class ManagerImpl implements Manager {
    private Map<String, Vehicle> vehicles;
    private Map<String, Vehicle> defeatedVehicles;
    private Map<String, Part> parts;
    private BattleOperator battleOperator;

    public ManagerImpl() {
        this.battleOperator = new PanzerBattleOperator();
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String type = arguments.get(0);
        String model = arguments.get(1);
        double weight =Double.parseDouble(arguments.get(2));
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(arguments.get(3)));
        long attack = Long.parseLong(arguments.get(4));
        long defense =  Long.parseLong(arguments.get(5));
        long hitPoints =  Long.parseLong(arguments.get(6));
        Vehicle vehicle = null;
        if(type.equals("Revenger")){
            vehicle = new Revenger(model,weight,price,attack,defense,hitPoints);
        }else {
            vehicle = new Vanguard(model,weight,price,attack,defense,hitPoints);
        }
        this.vehicles.putIfAbsent(model,vehicle);
        return String.format("Created %s Vehicle - %s",type,model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(0);
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight =Double.parseDouble(arguments.get(3));
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(arguments.get(4)));
        int additionalParam = Integer.parseInt(arguments.get(5));
        Part part = null;
        switch (type){
            case "Arsenal":
                part = new ArsenalPart(model,weight,price,additionalParam);
                this.vehicles.get(vehicleModel).addArsenalPart(part);
                break;
            case "Shell":
                part = new ShellPart(model,weight,price,additionalParam);
                this.vehicles.get(vehicleModel).addShellPart(part);
                break;
            case "Endurance":
                part = new EndurancePart(model,weight,price,additionalParam);
                this.vehicles.get(vehicleModel).addEndurancePart(part);
                break;
        }

        this.parts.putIfAbsent(model,part);
        return String.format("Added %s - %s to Vehicle - %s",type,model,vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(0);
        String result = "";
        if(this.vehicles.containsKey(model)){
            result = this.vehicles.get(model).toString();
        }else if(this.parts.containsKey(model)){
            result = this.parts.get(model).toString();
        }
        return result;
    }

    @Override
    public String battle(List<String> arguments) {
        String attacker = arguments.get(0);
        String defender = arguments.get(1);
        String winner = this.battleOperator.battle(vehicles.get(attacker),vehicles.get(defender));
        String loser = (winner.equals(attacker))?defender:attacker;
        this.defeatedVehicles.put(loser,this.vehicles.remove(loser));
        return String.format("%s versus %s -> %s Wins! Flawless Victory!",attacker,defender,winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        return String.format("Remaining Vehicles: %s%n", (this.vehicles.size() > 0) ? this.vehicles.keySet().toString().replaceAll("[\\[\\]]", "") : "None") +
                String.format("Defeated Vehicles: %s%n", (this.defeatedVehicles.size() > 0) ? this.defeatedVehicles.keySet().toString().replaceAll("[\\[\\]]", "") : "None") +
                String.format("Currently Used Parts: %d", this.vehicles.values().stream().mapToLong(x -> StreamSupport.stream(x.getParts().spliterator(), false).count()).sum());
    }


}
