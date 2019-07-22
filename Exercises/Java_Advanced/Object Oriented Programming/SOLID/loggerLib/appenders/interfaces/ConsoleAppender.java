package appenders.interfaces;

import enums.Report;
import layouts.interfaces.Layout;

public class ConsoleAppender implements Appender {
    Layout layout;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void append(String date, Report report, String message) {
        System.out.println(layout.format(date,report,message));
    }
}
