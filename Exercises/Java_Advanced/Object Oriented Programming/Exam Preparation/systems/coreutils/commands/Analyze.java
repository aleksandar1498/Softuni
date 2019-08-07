package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;

public class Analyze extends Command {
    @Inject
    Systema systema;
    public Analyze(String[] data) {
        super(data);
    }

    public Systema getSystema() {
        return this.systema;
    }

    @Override
    public void execute() {
        System.out.println(this.getSystema().toString());
    }
}
