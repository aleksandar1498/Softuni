package appenders.models;

import appenders.interfaces.Appender;
import enums.Report;
import layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private Report reportLevel;
    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = Report.INFO;
    }

    public Report getReportLevel() {
        return reportLevel;
    }

    public void setReportLevel(Report reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public void append(String date, Report report, String message) throws Exception {
        if(this.getReportLevel().ordinal() < report.ordinal()){
            throw new Exception("Error");
        }
    }

    public Layout getLayout() {
        return layout;
    }
}
