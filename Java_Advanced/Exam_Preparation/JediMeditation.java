package exam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediMeditation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern yoda = Pattern.compile("y\\d+");
        Pattern jedi = Pattern.compile("([mkptsy]\\d+)");
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> jediSet = new LinkedHashSet<>();
        Deque<String> padawans = new ArrayDeque<>();
        Deque<String> crazyPadawans = new ArrayDeque<>();
        Deque<String> masters = new ArrayDeque<>();
        Deque<String> knights = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher m = jedi.matcher(input);
            while (m.find()) {
                jediSet.add(m.group());
            }


        }
        Iterator<String> iterator = jediSet.iterator();
        while (iterator.hasNext()) {
            String nextJedi = iterator.next();
            switch (nextJedi.charAt(0)) {
                case 'm':

                    masters.offer(nextJedi);

                    break;
                case 'p':

                    padawans.offer(nextJedi);

                    break;
                case 'k':

                    knights.offer(nextJedi);

                    break;
                case 't':
                case 's':

                    crazyPadawans.offer(nextJedi);

                    break;
            }
        }


        Matcher yodaMatcher = yoda.matcher(jediSet.toString().replaceAll("[\\[\\],]", ""));
        if (yodaMatcher.find()) {
            masters.forEach(x -> System.out.print(x + " "));
            knights.forEach(x -> System.out.print(x + " "));
            crazyPadawans.forEach(x -> System.out.print(x + " "));
            padawans.forEach(x -> System.out.print(x + " "));
        } else {
            crazyPadawans.forEach(x -> System.out.print(x + " "));
            masters.forEach(x -> System.out.print(x + " "));
            knights.forEach(x -> System.out.print(x + " "));
            padawans.forEach(x -> System.out.print(x + " "));
        }


    }
}
