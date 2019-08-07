package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import models.hardware.HeavyHardware;

public class RegisterHeavyHardware extends Command {
    @Inject
    private Systema system;

    public RegisterHeavyHardware(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        if(!this.system.getHardwares().containsKey(super.getData()[0])){
            this.system.getHardwares().put(super.getData()[0],new HeavyHardware(super.getData()[0],
                    Integer.parseInt(super.getData()[1]),
                    Integer.parseInt(super.getData()[2])));
        }
    }
}
