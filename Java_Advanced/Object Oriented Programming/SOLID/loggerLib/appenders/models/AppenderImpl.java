package appenders.models;

import appenders.interfaces.Appender;
import enums.Report;
import layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private Report reportLevel;
    private int appendedMessages;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = Report.INFO;
        this.appendedMessages = 0;
    }

    private Report getReportLevel() {
        return this.reportLevel;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    private int getAppendedMessages() {
        return this.appendedMessages;
    }

    public void setReportLevel(Report reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected void increaseAppended() {
        this.appendedMessages++;
    }

    @Override
    public void append(String date, Report report, String message) throws Exception {
        if (this.getReportLevel().ordinal() > report.ordinal()) {
            throw new Exception("Error");
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(),
                this.getAppendedMessages());
    }
}
