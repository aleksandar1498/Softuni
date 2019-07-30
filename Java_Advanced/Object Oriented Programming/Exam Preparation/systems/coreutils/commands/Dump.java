package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import interfaces.Hardware;

public class Dump extends Command {
    @Inject
    private Systema systema;
    public Dump(String[] data) {
        super(data);
    }

    private Systema getSystema() {
        return systema;
    }

    @Override
    public void execute() {

        Hardware hardware = this.systema.getHardwares().remove(super.getData()[0]);
        if(hardware != null){
            this.systema.getDump().add(hardware);
        }
    }
}
