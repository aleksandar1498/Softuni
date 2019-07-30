package models.dumps;

import interfaces.Dump;
import interfaces.Hardware;
import interfaces.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class DumpImpl implements Dump {
    Map<String, Hardware> dumps;

    public DumpImpl() {
        this.dumps = new LinkedHashMap<>();
    }

    @Override
    public Hardware restore(String string) {
        if(this.dumps.containsKey(string)){
            return this.dumps.remove(string);
        }
        return null;
    }

    @Override
    public void destroy(String string) {
        this.dumps.remove(string);
    }

    @Override
    public void add(Hardware hardware) {
        this.dumps.putIfAbsent(hardware.getName(),hardware);
    }

    @Override
    public boolean contains(String string) {
        return this.dumps.containsKey(string);
    }

    @Override
    public String toString() {

        String builder = "Dump Analysis" + System.lineSeparator() +
                String.format("Power Hardware Components: %d",
                        this.dumps.values().stream().filter(d -> d.getClass().getSimpleName().equals("PowerHardware")).count()) +
                System.lineSeparator() +
                String.format("Heavy Hardware Components: %d",
                        this.dumps.values().stream().filter(d -> d.getClass().getSimpleName().equals("HeavyHardware")).count()) +
                System.lineSeparator() +
                String.format("Express Software Components: %d",
                        this.dumps.values().stream().flatMap(h -> h.getSoftwares().stream()).filter(s -> s.getClass().getSimpleName().equals("ExpressSoftware")).count()) +
                System.lineSeparator() +
                String.format("Light Software Components: %d",
                        this.dumps.values().stream().flatMap(h -> h.getSoftwares().stream()).filter(s -> s.getClass().getSimpleName().equals("LightSoftware")).count()) +
                System.lineSeparator() +
                String.format("Total Dumped Memory: %d",
                        this.dumps.values().stream().mapToInt(h -> h.getSoftwares().stream().mapToInt(Software::getMemoryConsumption).sum()).sum()) +
                System.lineSeparator() +
                String.format("Total Dumped Capacity: %d",
                        this.dumps.values().stream().mapToInt(h -> h.getSoftwares().stream().mapToInt(Software::getCapacityConsumption).sum()).sum());
        return builder;
    }
}
