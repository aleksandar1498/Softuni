package models.hardware;

import interfaces.Hardware;
import interfaces.Software;

import java.util.*;

public abstract class HardwareImpl implements Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private int availableCapacity ;
    private  int availableMemory;
    private List<Software> softwares;
    public HardwareImpl(String name,int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.maximumCapacity = this.availableCapacity =  maximumCapacity;
        this.maximumMemory = this.availableMemory = maximumMemory;
        this.softwares = new ArrayList<>();
    }

    private int getAvailableCapacity() {
        return this.availableCapacity;
    }

    private int getAvailableMemory() {
        return this.availableMemory;
    }

    private void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    private void setAvailableMemory(int availableMemory) {
        this.availableMemory = availableMemory;
    }

    private int getMaximumCapacity() {
        return maximumCapacity;
    }

    private int getMaximumMemory() {
        return maximumMemory;
    }

    private List<Software> getSoftwares() {
        return softwares;
    }

    protected void setType(String type) {
        this.type = type;
    }

    @Override
    public void register(Software software) {
        if(this.getSoftwares().stream().noneMatch(s -> s.getName().equals(software.getName()))){
            if(this.getMaximumCapacity() >= software.getCapacityConsumption() && this.getMaximumMemory() >= software.getMemoryConsumption()){
                this.getSoftwares().add(software);
                this.setAvailableCapacity(this.getAvailableCapacity()-software.getCapacityConsumption());
                this.setAvailableMemory(this.getAvailableMemory()-software.getMemoryConsumption());
            }
        }
    }
}
