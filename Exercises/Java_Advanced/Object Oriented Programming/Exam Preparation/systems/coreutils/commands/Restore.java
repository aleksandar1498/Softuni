package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import interfaces.Hardware;

public class Restore extends Command {
    @Inject
    private Systema systema;
    public Restore(String[] data) {
        super(data);
    }

    public Systema getSystema() {
        return systema;
    }

    @Override
    public void execute() {
        if(this.getSystema().getDump().contains(super.getData()[0])){
            Hardware hardware = this.getSystema().getDump().restore(super.getData()[0]);
            this.getSystema().getHardwares().putIfAbsent(hardware.getName(),hardware);
        }
    }
}
