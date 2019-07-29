package layouts.interfaces;

import enums.Report;

public interface Layout {
    String format(String date, Report report, String message);
}
