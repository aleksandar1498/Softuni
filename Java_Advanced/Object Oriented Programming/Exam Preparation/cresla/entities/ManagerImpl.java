package cresla.entities;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.entities.reactors.Reactors;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManagerImpl implements Manager {
    private static int index = 1;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;
    public ManagerImpl() {
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
//Parameters – type (string), additionalParameter (int), moduleCapacity (int).
        String type = arguments.get(0);
        int additionalParam = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));
        Reactor reactor = null;
        switch (type) {
            case "Cryo":
                reactor = new CryoReactor(index, moduleCapacity, additionalParam);
                break;
            case "Heat":
                reactor = new HeatReactor(index, moduleCapacity, additionalParam);
                break;
        }
        this.reactors.putIfAbsent(index, reactor);
        return String.format("Created %s Reactor – %d", type, index++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {

        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));
        Module module;
        switch (type) {
            case "CryogenRod":
                 module = new CryogenRod(index, additionalParam);
                this.modules.putIfAbsent(index,module);
                this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(index, additionalParam);
                this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
                this.modules.putIfAbsent(index,module);
                break;
            case "HeatProcessor":
                module = new CooldownSystem(index, additionalParam);
                this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
                this.modules.putIfAbsent(index,module);
                break;
        }

        return String.format("Added %s - %d to Reactor - %d", type, index++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        final int id = Integer.parseInt(arguments.get(0));
        if (this.reactors.containsKey(id)) {
            return this.reactors.get(id).toString();
        } else if(this.modules.containsKey(id)){
            return this.modules.get(id).toString();
        }
        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) throws NoSuchFieldException {

        long cryoReactors = this.reactors.values().stream().filter(x -> x.getClass().getSimpleName().equals("CryoReactor")).count();
        long heatReactors = this.reactors.values().stream().filter(x -> x.getClass().getSimpleName().equals("HeatReactor")).count();
        long totEnergyModuls = this.modules.values().stream().filter(m -> {
            if(m instanceof EnergyModule){
                return true;
            }
            return false;
        }).count();
        long totAbsorbingModuls = this.modules.values().stream().filter(m -> {
            if(m instanceof AbsorbingModule){
                return true;
            }
            return false;
        }).count();
        long totalEnergyOutput = this.reactors.values().stream().mapToLong(x -> {
           if(x.getTotalEnergyOutput() > x.getTotalHeatAbsorbing()){
               return 0;
           }
           return x.getTotalEnergyOutput();

        }).sum();
        long totalHeatAbsorbing = this.reactors.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();
        return String.format("Cryo Reactors: %d\n" +
                        "Heat Reactors: %d\n" +
                        "Energy Modules: %d\n" +
                        "Absorbing Modules: %d\n" +
                        "Total Energy Output: %d\n" +
                        "Total Heat Absorbing: %d"
                , cryoReactors
                , heatReactors
                , totEnergyModuls
                , totAbsorbingModuls
                , totalEnergyOutput
                , totalHeatAbsorbing);
    }
}
