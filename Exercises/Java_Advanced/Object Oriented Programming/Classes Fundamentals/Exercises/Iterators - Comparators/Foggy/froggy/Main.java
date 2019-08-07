package froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Lake lake=new Lake();
        lake.integers.addAll(Arrays.asList(scanner.nextLine().replaceAll(",","").split(" ")).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));


        List<Integer> vals=new ArrayList<>();
        for (Integer integer : lake) {
            vals.add(integer);
        }
        System.out.println(vals.toString().replaceAll("[\\[\\]]",""));
    }
}
