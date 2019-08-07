package models.commands;

import annotations.Inject;
import interfaces.Hardware;
import models.hardware.HardwareImpl;
import models.hardware.PowerHardware;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RegisterPowerHardware extends Command {
    @Inject
    private Map<String,Hardware> hardwares;

    public RegisterPowerHardware(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        System.out.println();
        if(!this.hardwares.containsKey(super.getData()[0])){
          this.hardwares.put(super.getData()[0], new PowerHardware(super.getData()[0],Integer.parseInt(super.getData()[1]),Integer.parseInt(super.getData()[2])));
        }
    }
}
