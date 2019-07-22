package layouts;

import enums.Report;
import layouts.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, Report report, String message) {
        return "<log>\n" +
                "\t<date>3/31/2015 5:33:07 PM</date>\n" +
                "\t<level>ERROR</level>\n" +
                "\t<message>Error parsing request</message>\n" +
                "</log>\n";
    }
}
