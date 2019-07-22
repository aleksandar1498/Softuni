package appenders.models;

import appenders.interfaces.Appender;
import enums.Report;
import layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    public AppenderImpl(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }
}
