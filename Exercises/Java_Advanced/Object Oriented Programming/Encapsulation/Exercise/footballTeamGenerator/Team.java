package footballTeamGenerator;

import java.util.*;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
            if(players.stream().noneMatch(x -> x.getName().equals(player.getName()))){
                players.add(player);
            }




    }

    public void removePlayer(String name) {
        Iterator<Player> iterator=this.players.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getName().equals(name)){
                iterator.remove();
                return;
            }
        }

         throw new IllegalArgumentException(String.format("Player %s is not in %s team.",name,this.name));

    }

    public double getRating() {
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.matches("\\s+")) {
            throw new IllegalArgumentException("A name should not be empty.");

        }
        this.name = name;
    }

}
