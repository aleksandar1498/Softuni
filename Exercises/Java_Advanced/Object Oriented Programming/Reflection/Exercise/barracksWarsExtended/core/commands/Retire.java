package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    @Inject
    private Repository repository;
    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String result = "";
        try {
           this.repository.removeUnit(super.getData()[1]);
           result = super.getData()[1]+" retired!";
        } catch (ExecutionControl.NotImplementedException e) {
            result ="No such units in repository.";
        }
        return result;
    }
}
