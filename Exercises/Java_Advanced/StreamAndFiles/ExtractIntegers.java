package lineardatastructure.streamfilesdirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";
        try(Scanner scanner=new Scanner(new FileInputStream(path));
            PrintWriter printWriter=new PrintWriter(new FileOutputStream(outPath))){
            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    printWriter.println(scanner.nextInt());
                }
                scanner.next();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
