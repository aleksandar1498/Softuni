package models.hardware;

import interfaces.Hardware;
import interfaces.Software;

import java.util.*;

public abstract class HardwareImpl implements Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private int availableCapacity;
    private int availableMemory;
    private List<Software> softwares;

    public HardwareImpl(String name, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.maximumCapacity = this.availableCapacity = maximumCapacity;
        this.maximumMemory = this.availableMemory = maximumMemory;
        this.softwares = new ArrayList<>();
    }



    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.getSoftwares().size();
    }

    public int getAvailableCapacity() {
        return this.availableCapacity;
    }

    public int getAvailableMemory() {
        return this.availableMemory;
    }


    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public void remove(Software software){
        this.softwares.remove(software);
        this.setAvailableCapacity(this.getAvailableCapacity()+software.getCapacityConsumption());
        this.setAvailableMemory(this.getAvailableMemory()+software.getMemoryConsumption());

    }
    private void addSoftware(Software software) {
        this.softwares.add(software);
    }


    public List<Software> getSoftwares() {
        return Collections.unmodifiableList(softwares);
    }


    protected void setType(String type) {
        this.type = type;
    }

    private void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    private void setAvailableMemory(int availableMemory) {
        this.availableMemory = availableMemory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hardware Component - %s",this.name));
        builder.append(System.lineSeparator());
        builder.append(String.format("Express Software Components - %d",this.softwares.stream().filter(software -> software.getClass().getSimpleName().equals("ExpressSoftware")).count()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Light Software Components - %d",this.softwares.stream().filter(software -> software.getClass().getSimpleName().equals("LightSoftware")).count()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Memory Usage: %d / %d",
                this.getSoftwares().stream().mapToInt(Software::getMemoryConsumption).sum(),
                this.getMaximumMemory()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Capacity Usage: %d / %d" ,
                this.getSoftwares().stream().mapToInt(Software::getCapacityConsumption).sum(),
                this.getMaximumCapacity()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Type: %s",this.getClass().getSimpleName().replaceAll("Hardware","")));
        builder.append(System.lineSeparator());
        builder.append(String.format("Software Components: %s",(this.getSoftwares().size() == 0)?"None":this.getSoftwares().toString().replaceAll("[\\[\\]]","")));
        return builder.toString();
    }

    @Override
    public void register(Software software) {
        if (this.getSoftwares().stream().noneMatch(s -> s.getName().equals(software.getName()))) {
            if (this.getMaximumCapacity() >= software.getCapacityConsumption() && this.getMaximumMemory() >= software.getMemoryConsumption()) {
                this.addSoftware(software);
                this.setAvailableCapacity(this.getAvailableCapacity() - software.getCapacityConsumption());
                this.setAvailableMemory(this.getAvailableMemory() - software.getMemoryConsumption());
            }
        }
    }
}
