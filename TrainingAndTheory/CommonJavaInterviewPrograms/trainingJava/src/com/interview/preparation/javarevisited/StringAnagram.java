package com.interview.preparation.javarevisited;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class StringAnagram {
    public static void main(String[] args) {
        //366100
        long start = System.nanoTime();
        areAnagram("alex", "lexsa");
        System.out.println(System.nanoTime() - start);
    }

    private static boolean areAnagram(String firstWord, String secondWord) {
        if(firstWord.length() != secondWord.length()) return false;
        return mapCharacters(firstWord).toString().equals(mapCharacters(secondWord).toString());
    }

    private static Map<String, Integer> mapCharacters(String word) {
        Map<String, Integer> characters = new TreeMap<>();
        String[] letters = word.toLowerCase().split("\\s+");
        for (int i = 0; i < letters.length; i++) {
            if (!characters.containsKey(letters[i])) {
                characters.put(letters[i], 0);
            }
            characters.put(letters[i], characters.get(i)+1);
        }
        return characters;
    }
}
