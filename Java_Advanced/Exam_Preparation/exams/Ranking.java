package arena;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contests = new HashMap<>();
        Map<String, Map<String, Integer>> submissions = new TreeMap<>();
       String infoContests = scanner.nextLine();
        while (!infoContests.equals("end of contests")) {
            String[] data = infoContests.split(":");
contests.putIfAbsent(data[0],data[1]);


            infoContests = scanner.nextLine();
        }
        String infoSub = scanner.nextLine();
        while (!infoSub.equals("end of submissions")) {
            String[] dataSub = infoSub.split("=>");
            String contest = dataSub[0];
            String name = dataSub[2];
            int points = Integer.valueOf(dataSub[3]);
           if (contests.containsKey(contest) && contests.get(contest).equals(dataSub[1])) {
                submissions.putIfAbsent(name, new LinkedHashMap<>());
                if (submissions.get(name).containsKey(contest)) {
                    if (submissions.get(name).get(contest) < points) {
                        submissions.get(name).replace(contest,points);
                    }

                }else{
                    submissions.get(name).put(contest,points);
                }
            }
            infoSub=scanner.nextLine();
        }
String nameOfBestUser=submissions.entrySet().stream().sorted(Comparator.comparing(x -> x.getValue().values().stream().mapToInt(Integer::valueOf).sum(),Comparator.reverseOrder())).findFirst().get().getKey();
        System.out.printf("Best candidate is %s with total %d points.\n",nameOfBestUser,submissions.get(nameOfBestUser).values().stream().mapToInt(Integer::valueOf).sum());
        System.out.println("Ranking: ");
        submissions.entrySet().stream().forEach(user -> {
           System.out.println(user.getKey());
           user.getValue().entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())).forEach(contest -> System.out.printf("#  %s -> %d\n",contest.getKey(),contest.getValue()));

       });
    }
}
