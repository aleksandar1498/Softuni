package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import interfaces.Software;

public class ReleaseSoftwareComponent extends Command{
    @Inject
    private Systema system;
    public ReleaseSoftwareComponent(String[] data) {
        super(data);
    }



    @Override
    public void execute() {
        if(this.system.getHardwares().containsKey(super.getData()[0])){
            if(this.system.getHardwares().get(super.getData()[0]).getSoftwares().stream().filter(x -> x.getName().equals(super.getData()[1])).count() > 0){
                Software software =this.system.getHardwares().get(super.getData()[0]).getSoftwares().stream().filter(x -> x.getName().equals(super.getData()[1])).findFirst().orElse(null);
                this.system.getHardwares().get(super.getData()[0]).remove(software);
            }
        }
    }
}
