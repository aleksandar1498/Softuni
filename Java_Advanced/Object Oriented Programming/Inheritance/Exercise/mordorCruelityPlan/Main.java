package mordorCruelityPlan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Gandalf gandalf=new Gandalf();
        Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+")).forEach(gandalf::eatFood);
        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
