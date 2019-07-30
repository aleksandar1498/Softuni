package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> timeForBothTheCars = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double timesOfTheFirstPilot = 0.0;
        double timesOfTheSecondPilot = 0;

        for (int i = 0; i < timeForBothTheCars.size() / 2; i++) {
            if (timeForBothTheCars.get(i).equals(0)) {
                timesOfTheFirstPilot *= .8;
                continue;
            }
            timesOfTheFirstPilot += timeForBothTheCars.get(i);

        }
        for (int i = timeForBothTheCars.size() - 1; i > timeForBothTheCars.size()/2; i--) {
            if (timeForBothTheCars.get(i).equals(0)) {
                timesOfTheSecondPilot *= .8;
                continue;
            }
            timesOfTheSecondPilot += timeForBothTheCars.get(i);

        }
if(timesOfTheFirstPilot < timesOfTheSecondPilot){
    System.out.printf("The winner is left with total time: %.1f",timesOfTheFirstPilot);
}else{
    System.out.printf("The winner is right with total time: %.1f",timesOfTheSecondPilot);

}
    }
}
