package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import interfaces.Hardware;

public class Destroy extends Command {
    @Inject
    private Systema systema;

    public Destroy(String[] data) {
        super(data);
    }

    public Systema getSystema() {
        return systema;
    }

    @Override
    public void execute() {
        if (this.getSystema().getDump().contains(super.getData()[0])) {
            this.getSystema().getDump().destroy(super.getData()[0]);
        }
    }
}
