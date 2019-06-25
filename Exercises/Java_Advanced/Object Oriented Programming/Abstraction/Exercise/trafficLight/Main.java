package trafficLight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<TrafficLight> lights=new ArrayList<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(l -> lights.add(new TrafficLight(Light.valueOf(l))));
        int numChanges=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numChanges; i++) {
            for (TrafficLight trafficLight : lights) {
                trafficLight.changeLight();
                System.out.print(trafficLight+" ");
            }
            System.out.println();
        }


    }
}
