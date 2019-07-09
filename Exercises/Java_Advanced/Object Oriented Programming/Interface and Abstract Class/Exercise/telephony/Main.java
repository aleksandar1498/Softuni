package telephony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> numbers = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        List<String> urls= new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        Smartphone smartphone=new Smartphone(numbers,urls);
        for (String number : smartphone.getNumbers()) {
            System.out.println(smartphone.call(number));
        }
        for (String url : smartphone.getUrls()) {
            System.out.println(smartphone.browse(url));
        }

    }
}
