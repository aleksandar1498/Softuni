package arena;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> completedMissions = new TreeMap<>();
        TreeMap<String, Integer> failedMissions = new TreeMap<>();
        String action = scanner.nextLine();
        Pattern p=Pattern.compile(".*M.*I.*S.*S.*I.*O.*N.*"); // . stands for any character and * is used to define that it can be repeated 0 or more times
        Pattern completed=Pattern.compile(".*C.*");
        Pattern failed=Pattern.compile(".*X.*");
        while (!action.equals("Decrypt")) {
            Matcher m=p.matcher(action);

            if (!m.find()) {
                action = scanner.nextLine();
                continue;
            }
            String name = action.replaceAll("[^a-z]", "");
            char[] digits= action.replaceAll("[^\\d]","").toCharArray();
            int rating=0;

            for (char c:digits) {
                rating+=Integer.parseInt(c+"");
            }
            Matcher com=completed.matcher(action);
            Matcher fai=failed.matcher(action);
            if(fai.find()){
                failedMissions.put(name,rating);
            }else if(com.find()){
                completedMissions.put(name,rating);
            }
            action = scanner.nextLine();
        }
        String mostRatedSuccessful=completedMissions.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())).findFirst().get().getKey();

        String mostRatedFailed=failedMissions.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())).findFirst().get().getKey();



        System.out.printf("Completed mission %s with rating: %d\n",mostRatedSuccessful,completedMissions.get(mostRatedSuccessful));
        System.out.printf("Failed Mission %s with rating: %d",mostRatedFailed,failedMissions.get(mostRatedFailed));
    }
}
