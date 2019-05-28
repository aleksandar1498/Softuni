package lineardatastructure.streamfilesdirectories;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String words = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String text = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String out = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";
        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        try (BufferedReader wordsReader = Files.newBufferedReader(Paths.get(words));
             BufferedReader textReader = Files.newBufferedReader(Paths.get(words));
             PrintWriter result = new PrintWriter(new FileWriter(out))) {
            String wordsLine = "";
            while ((wordsLine = wordsReader.readLine()) != null) {
                Arrays.stream(wordsLine.split(" ")).forEach(word -> wordsMap.putIfAbsent(word, 0));
            }
            List<String> lines = Files.readAllLines(Paths.get(text));
            for (String line : lines) {
                String[] lineTokens = line.replaceAll("[\\W]+", " ").split(" ");
                for (String token :
                        lineTokens) {
                    if(wordsMap.containsKey(token)){
                        wordsMap.put(token,wordsMap.get(token)+1);
                    }
                }
            }
            wordsMap.entrySet().stream().sorted((e1,e2) -> {
                return e2.getValue().compareTo(e1.getValue());
            }).forEach(word -> {
                result.println(word.getKey()+" - "+word.getValue());
            });


        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
