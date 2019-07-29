import appenders.ConsoleAppender;
import appenders.FileAppender;
import appenders.interfaces.Appender;
import controllers.Controller;
import enums.Report;
import files.LogFile;
import files.interfaces.File;
import layouts.XmlLayout;
import layouts.interfaces.Layout;
import layouts.SimpleLayout;
import loggers.MessageLogger;
import loggers.interfaces.Logger;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Controller controller = new Controller();
        controller.parseInput();
    }
}
