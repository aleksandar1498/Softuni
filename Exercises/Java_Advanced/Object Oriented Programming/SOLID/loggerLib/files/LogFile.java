package files;

import enums.Report;
import files.interfaces.File;

public class LogFile implements File {
    StringBuilder buffer;

    public LogFile() {
        this.buffer = new StringBuilder();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String getContent() {
        return buffer.toString();
    }

    @Override
    public void write(String data) {
buffer.append(data);
    }
}
