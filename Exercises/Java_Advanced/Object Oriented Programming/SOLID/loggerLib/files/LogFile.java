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
        int size=0;
        for(char c: buffer.toString().toCharArray()){
            if(Character.isAlphabetic(c)){
                size+=(int)c;
            }
        }
        return size;
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
