package appenders.interfaces;

import enums.Report;

public interface Appender {
    void append(String date, Report report, String message) throws Exception;
    void setReportLevel(Report report);
}
