package layouts;

import enums.Report;
import layouts.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, Report report, String message) {
        return String.format("%s - %s - %s",date,report.name(),message);
    }
}
