package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import models.hardware.PowerHardware;

public class RegisterPowerHardware extends Command {
    @Inject
    private Systema system;

    public RegisterPowerHardware(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        System.out.println();
        if(!this.system.getHardwares().containsKey(super.getData()[0])){
          this.system.getHardwares().put(super.getData()[0], new PowerHardware(super.getData()[0],Integer.parseInt(super.getData()[1]),Integer.parseInt(super.getData()[2])));
        }
    }
}
