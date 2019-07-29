package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import models.software.LightSoftware;

public class RegisterLightSoftware extends Command {
    @Inject
    private Systema system;

    public RegisterLightSoftware(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        if(this.system.getHardwares().containsKey(super.getData()[0])){
            this.system.getHardwares().get(super.getData()[0]).register(
                    new LightSoftware(
                            super.getData()[1],
                            Integer.parseInt(super.getData()[2]),
                            Integer.parseInt(super.getData()[3])
                    )
            );
        }
    }
}
