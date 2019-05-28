package lineardatastructure.streamfilesdirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SumBytes {
    public static void main(String[] args) {
            long sumOfBytes=0;
            String path="C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
            try(BufferedReader reader= Files.newBufferedReader(Paths.get(path))){
                String line=reader.readLine();
                while(line != null){
                    for (int i = 0; i < line.length(); i++) {
                        sumOfBytes+=line.charAt(i);
                    }
                    line= reader.readLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        System.out.println(sumOfBytes);
    }

}
