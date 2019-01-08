package multidimensionalarrays.exams;

import java.util.*;

public class Genome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        TreeMap<String, Integer> genomes = new TreeMap<>();
        while (!action.equals("Stop!")) {

            if (action.matches("^([a-z!@#$?]+)=(\\d+)--(\\d+)<<([a-z]+)$")) {
                int lengthOfTheName = Integer.valueOf(action.substring(action.indexOf("=") + 1, action.indexOf("--")));
                String name = action.substring(0, action.indexOf("=")).replaceAll("[!@#$?]", "");
                if (lengthOfTheName != name.length()) {
                    action = scanner.nextLine();
                    continue;
                }
                String orgranism = action.substring(action.indexOf("<<") + 2, action.length());
                int numOfGen = Integer.valueOf(action.substring(action.indexOf("--") + 2, action.indexOf("<<")));

                if (genomes.containsKey(orgranism)) {

                    genomes.replace(orgranism, numOfGen + genomes.get(orgranism).intValue());
                } else {
                    genomes.put(orgranism, numOfGen);
                }
            }
            action = scanner.nextLine();
        }
        genomes.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach(x -> System.out.printf("%s has genome size of %d%n", x.getKey(), x.getValue()));
        //^[A-Za-z!@,#?!]+[=][\d][-]+[\d]+[<]+[a-z]+$
    }
}
