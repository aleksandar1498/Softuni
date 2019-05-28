package lineardatastructure.streamfilesdirectories;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class LineNumbers {
    public static void main(String[] args) {
        String path="C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String out="C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt";

        try(BufferedReader reader= Files.newBufferedReader(Paths.get(path));
            PrintWriter writer=new PrintWriter(new FileWriter(out))){
            String line=reader.readLine();
            int count=1;
            while(line != null){

                writer.println(count+". "+line);
                line= reader.readLine();
                count++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
