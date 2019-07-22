import appenders.ConsoleAppender;
import appenders.FileAppender;
import appenders.interfaces.Appender;
import files.LogFile;
import files.interfaces.File;
import layouts.interfaces.Layout;
import layouts.SimpleLayout;
import loggers.MessageLogger;
import loggers.interfaces.Logger;

public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


        System.out.println(file.getContent());

    }
}
