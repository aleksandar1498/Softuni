package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;

public class DumpAnalyze extends Command {
    @Inject
    Systema systema;
    public DumpAnalyze(String[] data) {
        super(data);
    }

    public Systema getSystema() {
        return systema;
    }

    @Override
    public void execute() {
        System.out.println(this.getSystema().getDump().toString());
    }
}
