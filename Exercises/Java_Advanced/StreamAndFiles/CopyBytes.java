package lineardatastructure.streamfilesdirectories;

import java.io.*;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";
        try (InputStream in = new FileInputStream(path);
             OutputStream outputStream = new FileOutputStream(outPath)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                String val = String.valueOf(oneByte);
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    for (int i = 0; i < val.length(); i++) {

                        outputStream.write(val.charAt(i));


                    }
                }
            }
        } catch (IOException e) {

        }
    }
}
