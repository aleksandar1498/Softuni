package models.software;

public class LightSoftware extends SoftwareImpl {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, (int) (capacityConsumption*1.5), (int) (memoryConsumption*.5));
        super.setType("Light");
    }
}
