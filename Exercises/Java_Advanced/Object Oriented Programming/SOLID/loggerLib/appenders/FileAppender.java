package appenders;

import appenders.models.AppenderImpl;
import enums.Report;
import files.interfaces.File;
import layouts.interfaces.Layout;


public class FileAppender extends AppenderImpl {
    File file;
    public FileAppender(Layout layout) {
        super(layout);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, Report report, String message) throws Exception {
        super.append(date,report,message);
        if(file == null){
            throw new NullPointerException("File is not set");
        }
        this.file.write(super.getLayout().format(date,report,message));
    }
}
