package trafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<TrafficLight> lights=new ArrayList<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(l -> lights.add(new TrafficLight(Light.valueOf(l))));
        int numChanges=Integer.parseInt(reader.readLine());
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < numChanges; i++) {
            for (TrafficLight trafficLight : lights) {
                trafficLight.changeLight();
                builder.append(trafficLight).append(" ");
            }
            System.out.println(builder.toString());
            builder.delete(0,builder.length());
        }


    }
}
