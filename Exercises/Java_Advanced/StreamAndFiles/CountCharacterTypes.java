package lineardatastructure.streamfilesdirectories;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String path = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String out = "C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources (1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt";
        List<Character> vowels=new ArrayList<>();
        Collections.addAll(vowels,'a','e','i','o','u');
        List<Character> symbols=new ArrayList<>();
        Collections.addAll(symbols,'!',',','.','?');
        int countVowels=0;
        int countConsonants=0;
        int countPunctuation=0;
        try (BufferedReader bufferedReader= Files.newBufferedReader(Paths.get(path));
             PrintWriter printWriter=new PrintWriter(new FileWriter(out))){
            String line="";
            while((line = bufferedReader.readLine()) != null){
                for (int i = 0; i < line.length(); i++) {
                    char c=line.charAt(i);
                    if(Character.isLetter(c) && vowels.contains(c)){
                        countVowels++;
                    }else if(Character.isLetter(c) && !vowels.contains(c)){
                        countConsonants++;
                    }else if(symbols.contains(c)){
                        countPunctuation++;
                    }
                }
                printWriter.println(line.toUpperCase());
            }
            printWriter.println("Vowels: "+countVowels);
            printWriter.println("Consonants: "+countConsonants);
            printWriter.println("Punctuation: "+countPunctuation);
        } catch (IOException e) {
e.printStackTrace();
        }
    }
}
