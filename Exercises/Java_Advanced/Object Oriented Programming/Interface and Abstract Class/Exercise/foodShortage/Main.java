package foodShortage;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Person person = null;
            String[] token = scanner.nextLine().split("\\s+");

            if (token.length == 3) {
                person = new Rebel(token[0], Integer.parseInt(token[1]), token[2]);
            } else {
                person = new Citizen(token[0], Integer.parseInt(token[1]), token[2], token[3]);
            }
            people.putIfAbsent(token[0], person);
        }
        String command = "";
        while (!"End".equals(command = scanner.nextLine())) {
            if(people.containsKey(command)){
                if (people.get(command) instanceof Citizen) {
                    ((Citizen) people.get(command)).buyFood();
                } else {
                    ((Rebel) people.get(command)).buyFood();
                }
            }

        }
        System.out.println(people.values().stream().mapToInt(x -> {
            if (x instanceof Citizen) {
                return ((Citizen) x).getFood();
            } else {
                return ((Rebel) x).getFood();
            }
        }).sum());
    }

}
