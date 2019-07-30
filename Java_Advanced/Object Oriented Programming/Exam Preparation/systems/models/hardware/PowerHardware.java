package models.hardware;

import interfaces.Hardware;

public class PowerHardware extends HardwareImpl {
    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name,maximumCapacity - ((maximumCapacity*3)/4), maximumMemory + ((maximumMemory*3)/4));
        super.setType("Power");
    }
}
