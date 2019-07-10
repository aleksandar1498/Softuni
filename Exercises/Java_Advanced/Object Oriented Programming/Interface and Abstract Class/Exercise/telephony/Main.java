package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = new ArrayList<>(Arrays.asList(bufferedReader.readLine().trim().split("\\s+")));
        List<String> urls= new ArrayList<>(Arrays.asList(bufferedReader.readLine().trim().split("\\s+")));

        Smartphone smartphone=new Smartphone(numbers,urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());

    }
}
