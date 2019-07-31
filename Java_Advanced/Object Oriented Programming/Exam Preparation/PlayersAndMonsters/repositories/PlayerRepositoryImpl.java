package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (this.getPlayers().stream().anyMatch(x -> x.getUsername().equals(player.getUsername()))) {
            throw new IllegalArgumentException("Player " + player.getUsername() + " already exists!");
        }
        this.getPlayers().add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        return this.getPlayers().remove(player);

    }

    @Override
    public Player find(String name) {
        return this.getPlayers().stream().filter(x -> x.getUsername().equals(name)).findFirst().orElse(null);
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
