package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Team team=new Team("Minior");
        int n=Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String [] token=reader.readLine().split("\\s+");
            team.addPlayer(new Person(token[0],token[1],Integer.parseInt(token[2]),Double.parseDouble(token[3])));
        }
        System.out.println("First team have " + team.getFirstTeam().size()+" players");
        System.out.println("Reserve team have " + team.getReserveTeam().size()+" players");

    }

}
