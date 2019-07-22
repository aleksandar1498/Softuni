package appenders;

import appenders.models.AppenderImpl;
import enums.Report;
import layouts.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {


    public ConsoleAppender(Layout layout) {
        super(layout);
    }
    @Override
    public void append(String date, Report report, String message) throws Exception {
        super.append(date,report,message);
        System.out.print(super.getLayout().format(date,report,message));
    }
}
