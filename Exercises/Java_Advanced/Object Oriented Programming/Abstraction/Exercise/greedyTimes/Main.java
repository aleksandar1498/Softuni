
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

            if (item.length() == 3) {
                typeItem = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                typeItem = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                typeItem = "Gold";
            }

            if (typeItem.equals("")) {
                continue;
            }

            bag.add(typeItem,new Item(item,quantity));
        }
        System.out.println();

        // print
        for (Map.Entry<String, LinkedList<Item>> stringLinkedListEntry : bag) {
            Long sumValues = stringLinkedListEntry.getValue().stream().mapToLong(Item::getQuantity).sum();

            System.out.println(String.format("<%s> $%s", stringLinkedListEntry.getKey(), sumValues));

            stringLinkedListEntry.getValue().stream().sorted((e1, e2) -> Long.compare(e2.getQuantity(),e1.getQuantity())).forEach(i -> System.out.println("##" + i.getName() + " - " + i.getQuantity()));

        }

    }
}