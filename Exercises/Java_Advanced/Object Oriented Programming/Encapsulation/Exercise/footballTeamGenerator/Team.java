package footballTeamGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {

            players.putIfAbsent(player.getName(), player);



    }

    public void removePlayer(String name) {
        if (!players.containsKey(name)) {
            // throw new IllegalArgumentException()
            System.out.printf("Player %s is not in %s team.%n", name, this.getName());
        } else {
            players.remove(name);
        }

    }

    public double getRating() {
        return this.players.entrySet().stream().mapToDouble(x -> x.getValue().overallSkillLevel()).sum();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.matches("\\s+")) {
            System.out.println("A name should not be empty.");
            return;
        }
        this.name = name;
    }

}
