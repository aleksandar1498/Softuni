package lineardatastructure.streamfilesdirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SumLines {
    public static void main(String[] args) {
        String path="C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try(BufferedReader reader= Files.newBufferedReader(Paths.get(path))){
            String line=reader.readLine();
            while(line != null){
                System.out.println(Arrays.stream(line.split("")).mapToInt(x -> (int)x.charAt(0)).sum());
                line= reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
