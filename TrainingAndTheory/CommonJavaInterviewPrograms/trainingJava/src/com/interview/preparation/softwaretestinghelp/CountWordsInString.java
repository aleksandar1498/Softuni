package com.interview.preparation.softwaretestinghelp;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWordsInString {
    public static void main(String[] args) {
        Map<String,Integer> letters = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String [] words = scanner.nextLine().split("\\s+");
        Arrays.stream(words).forEach(x -> {
            if(!letters.containsKey(x)){
                letters.put(x,0);
            }
            letters.put(x,letters.get(x)+1);
        });
        System.out.println(letters);

    }
}
