package lineardatastructure.streamfilesdirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {
        String path="C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath="C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";
        List<Character> symbols=new ArrayList<>();
        Collections.addAll(symbols,'.', ',', '!', '?');
        try(InputStream in=new FileInputStream(path);
            OutputStream out=new FileOutputStream(outPath))
        {
            int oneByte=in.read();
            while(oneByte >= 0){
                if(!symbols.contains((char)oneByte)){
                    out.write(oneByte);
                }
                oneByte=in.read();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
