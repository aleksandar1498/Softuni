package models.hardware;

public class HeavyHardware extends HardwareImpl {
    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity*2, (int) (maximumMemory*.75));
        super.setType("Heavy");
    }
}
