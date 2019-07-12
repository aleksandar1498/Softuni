package word.common;

import word.interfaces.CommandInterface;
import word.models.CommandImpl;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text){
        System.out.println();
        CommandInterface commandInterface= new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
