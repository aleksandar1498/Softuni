package models.software;

public class LightSoftware extends SoftwareImpl {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption + (capacityConsumption/2), memoryConsumption-(memoryConsumption/2));
        super.setType("Light");
    }
}
