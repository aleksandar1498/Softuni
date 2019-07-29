package lineardatastructure.streamfilesdirectories;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
            PrintWriter printWriter=new PrintWriter(new FileWriter(outPath))){
            int counter=1;
            String line=bufferedReader.readLine();
            while(line != null){
                if(counter%3 == 0){
                    printWriter.println(line);
                }
                line=bufferedReader.readLine();
                counter++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
