package layouts;

import enums.Report;
import layouts.interfaces.Layout;

public class XmlLayout implements Layout {
    public XmlLayout() {
    }

    @Override
    public String format(String date, Report report, String message) {
        return "<log>\n" +
                "\t<date>"+date+"</date>\n" +
                "\t<level>"+report.name()+"</level>\n" +
                "\t<message>"+message+"</message>\n" +
                "</log>\n";
    }
}
