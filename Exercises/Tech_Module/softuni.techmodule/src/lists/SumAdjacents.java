package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SumAdjacents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> adjacentsNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        boolean allSummed = false;
        while (!allSummed) {
            for (int i = 0; i < adjacentsNumbers.size() - 1; i++) {
                if (adjacentsNumbers.get(i).equals(adjacentsNumbers.get(i + 1))) {
                    adjacentsNumbers.set(i, adjacentsNumbers.get(i) * 2);
                    adjacentsNumbers.remove(i + 1);
                }
            }
            if (!containsEqual(adjacentsNumbers)) {
                allSummed = true;
            }
        }
        System.out.println("Sum complete "+String.join(" ", adjacentsNumbers.toString()));


    }

    public static boolean containsEqual(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
