package models.hardware;

import interfaces.Hardware;

public class PowerHardware extends HardwareImpl {
    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, (int) (maximumCapacity*.25), (int) (maximumMemory*1.75));
        super.setType("Power");
    }
}
