package files.interfaces;

import enums.Report;

public interface File {
    int size();
    String getContent();
    void write(String data);
}
