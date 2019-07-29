package models.software;

import interfaces.Software;

public abstract class SoftwareImpl implements Software {
    private String name;
    private String type;
    private int capacityConsumption;
    private int memoryConsumption;

    public SoftwareImpl(String name, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    @Override
    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }

    protected void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
