package oop.catlady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();
        String line = "";
        while (!"End".equals(line = scanner.nextLine())) {
            String[] catToken = line.split(" ");
            switch (catToken[0]) {
                case "Siamese":
                    cats.add(new Siamese(catToken[1], Double.parseDouble(catToken[2])));
                    break;
                case "Cymric":
                    cats.add(new Cymric(catToken[1], Double.parseDouble(catToken[2])));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(catToken[1], Double.parseDouble(catToken[2])));
                    break;
            }
        }
        String searchedCat=scanner.nextLine();
        Cat myCat = cats.stream().filter(cat -> cat.getName().equals(searchedCat)).findFirst().orElse(null);
        System.out.println(myCat.toString());
    }
}
