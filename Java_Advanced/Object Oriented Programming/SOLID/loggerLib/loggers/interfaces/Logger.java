package loggers.interfaces;

import enums.Report;

public interface Logger {
    void log(String date,Report report, String message);
    void logInfo(String date, String message);
    void logWarning(String date, String message);
    void logError(String date, String message);
    void logCritical(String date, String message);
    void logFatal(String date, String message);
}
