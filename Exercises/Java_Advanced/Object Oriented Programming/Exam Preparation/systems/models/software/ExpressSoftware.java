package models.software;

public class ExpressSoftware extends SoftwareImpl {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption*2);
        super.setType("Express");
    }
}
