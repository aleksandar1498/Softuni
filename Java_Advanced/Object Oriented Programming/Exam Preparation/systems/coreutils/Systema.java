package coreutils;

import interfaces.Dump;
import interfaces.Hardware;
import interfaces.Software;
import models.dumps.DumpImpl;

import java.util.Map;

public class Systema {
    private Map<String,Hardware> hardwares;
    private Dump dump;
    public Systema(Map<String,Hardware> hardwares) {
        this.dump = new DumpImpl();
        this.hardwares = hardwares;
    }

    public Map<String, Hardware> getHardwares() {
        return hardwares;
    }

    public Dump getDump() {
        return dump;
    }

    @Override
    public String toString() {

        String builder =
                "System Analysis" +
                System.lineSeparator() +
                String.format("Hardware Components: %d", this.getHardwares().size()) +
                System.lineSeparator() +
                String.format("Software Components: %d",
                        this.getHardwares().values().stream().mapToInt(Hardware::getCount).sum()) +
                System.lineSeparator() +
                String.format("Total Operational Memory: %d / %d",
                        this.getHardwares().values().stream().flatMap(h -> h.getSoftwares().stream()).mapToInt(Software::getMemoryConsumption).sum(),
                        this.getHardwares().values().stream().mapToInt(Hardware::getMaximumMemory).sum()) +
                System.lineSeparator() +
                String.format("Total Capacity Taken: %d / %d",
                        this.getHardwares().values().stream().flatMap(h -> h.getSoftwares().stream()).mapToInt(Software::getCapacityConsumption).sum(),
                        this.getHardwares().values().stream().mapToInt(Hardware::getMaximumCapacity).sum());
        return builder;
    }
}
