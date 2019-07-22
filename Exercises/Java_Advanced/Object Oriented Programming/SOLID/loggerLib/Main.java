import appenders.interfaces.Appender;
import appenders.interfaces.ConsoleAppender;
import enums.Report;
import layouts.interfaces.Layout;
import layouts.SimpleLayout;
import loggers.MessageLogger;
import loggers.interfaces.Logger;

public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        Logger logger = new MessageLogger(consoleAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

    }
}
