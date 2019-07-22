package loggers;

import appenders.interfaces.Appender;
import enums.Report;
import loggers.interfaces.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger {
    Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void log(String date, Report report, String message) {
        for (Appender appender : appenders) {
            try {
                appender.append(date,report,message);

            } catch (Exception e) {
              e.getMessage();
            }
        }
    }

    @Override
    public void logInfo(String date, String message) {
        this.log(date, Report.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        this.log(date, Report.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        this.log(date, Report.ERROR, message);
    }

    @Override
    public void logCritical(String date, String message) {
        this.log(date, Report.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        this.log(date, Report.FATAL, message);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LoggerInfo");
        for (Appender appender : this.appenders) {
            builder.append(System.lineSeparator());
            builder.append(appender);
        }
        return builder.toString();
    }
}
