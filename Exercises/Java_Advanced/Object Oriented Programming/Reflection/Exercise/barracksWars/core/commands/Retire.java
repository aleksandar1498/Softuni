package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String result = "";
        try {
           super.getRepository().removeUnit(super.getData()[1]);
           result = super.getData()[1]+" retired!";
        } catch (ExecutionControl.NotImplementedException e) {
            result ="No such units in repository.";
        }
        return result;
    }
}
