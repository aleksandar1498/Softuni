package lineardatastructure.streamfilesdirectories;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        String path = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String out = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt";

        try (BufferedReader bufferedReader= Files.newBufferedReader(Paths.get(path));
             PrintWriter printWriter=new PrintWriter(new FileWriter(out))){
                String line="";
                while((line = bufferedReader.readLine()) != null){
                    printWriter.println(line.toUpperCase());
                }
        } catch (IOException e) {

        }
    }
}
