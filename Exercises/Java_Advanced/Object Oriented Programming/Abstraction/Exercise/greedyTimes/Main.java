
package greedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        //  Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < items.length; i += 2) {
            String item = items[i];
            long quantity = Long.parseLong(items[i + 1]);
            String typeItem = "";
            Item currentItem=new Item(item,quantity);
            if (item.length() == 3) {
                bag.addCash(currentItem);

            } else if (item.toLowerCase().endsWith("gem")) {
                bag.addGem(currentItem);

            } else if (item.toLowerCase().equals("gold")) {
                bag.addGold(currentItem);

            }



        }


        System.out.println(bag.toString());

    }
}