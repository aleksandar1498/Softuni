package lineardatastructure.functionalprogramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> vals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> predicate = buildPredicate(n);
        Collections.reverse(vals);
        vals.stream()
                .filter(predicate)
                .forEach(x -> System.out.print(x+" "));
    }

    private static Predicate<Integer> buildPredicate(int n) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % n == 0) {
                    return false;
                }
                return true;
            }
        };
    }
}
