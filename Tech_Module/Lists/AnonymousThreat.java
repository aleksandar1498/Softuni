package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String[] action = scanner.nextLine().split(" ");
        while (!action[0].equals("3:1")) {
            switch (action[0]) {
                case "merge":
                    int startIndex = Integer.valueOf(action[1]);
                    int endIndex = Integer.valueOf(action[2]);
                    if (startIndex < 0) {
                        startIndex = 0;
			
                    }
                    if (startIndex > stringList.size() - 1) {
                        action = scanner.nextLine().split(" ");
                        continue;
                    }
                    if(endIndex > stringList.size() -1){
                        endIndex=stringList.size()-1;
                    }
                    for (int i = startIndex; i < endIndex; i++) {
                        stringList.set(startIndex, stringList.get(startIndex).concat(stringList.get(startIndex + 1)));
                        stringList.remove(stringList.get(startIndex + 1));

                        //  i--;

                    }

                    break;
                case "divide":
                    int index = Integer.valueOf(action[1]);
                    if (index < 0 || index > stringList.size()-1) {
                        action = scanner.nextLine().split(" ");

                        continue;
                    }

                    int numPartitions = Integer.valueOf(action[2]);
                    if (numPartitions < 0 || numPartitions > 100){
                        action = scanner.nextLine().split(" ");
                        continue;
                    }
                    List<String> dividedItem = divideListItem(stringList.get(index), numPartitions);

                    int iterator = 0;
                    for (int i = index + 1; i <= dividedItem.size() + index; i++) {
                        stringList.add(i, dividedItem.get(iterator));
                        iterator++;
                    }
                    stringList.remove(stringList.get(index));
                    break;
            }
            action = scanner.nextLine().split(" ");
        }
        System.out.println(stringList.toString().replaceAll("[\\[\\],]", ""));
    }

    public static List<String> divideListItem(String word, int numPart) {
        List<String> result = new ArrayList<>();

        if (word.length() % numPart == 0) {
            int unit = word.length() / numPart;
            for (int i = 0; i < word.length(); i += unit) {
                result.add(word.substring(i, i + unit));

            }
        } else {
            int unit = (int) Math.floor(word.length() / (double) numPart);
            int lastUnit = (int) word.length() - (unit * (numPart - 1));
            for (int i = 0; i < word.length(); i += unit) {
                if (i == word.length() - lastUnit) {
                    result.add(word.substring(i, i + lastUnit));
                    break;
                }
                result.add(word.substring(i, i + unit));

            }

        }
        return result;
    }
}
