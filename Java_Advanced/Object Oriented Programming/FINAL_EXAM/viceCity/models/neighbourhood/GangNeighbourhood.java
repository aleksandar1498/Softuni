package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Deque<String> gunNames = new ArrayDeque<>();
        mainPlayer.getGunRepository().getModels().stream().map(Gun::getName).forEach(gunNames::offer);
        List<Player> players = civilPlayers.stream().filter(x -> !x.getName().equals("Vercetti")).collect(Collectors.toList());
        Player currentPlayer = players.remove(0);
        while (true) {
            Gun gun = mainPlayer.getGunRepository().find(gunNames.poll());
            if (gun == null) {
                break;
            }

            while (true) {
                int bullets = gun.fire();
                if (bullets == 0) {
                    //we are shure that the weapon is removed
                    mainPlayer.getGunRepository().remove(gun);
                    break;
                }
                currentPlayer.takeLifePoints(bullets);
                if (!currentPlayer.isAlive()) {
                    civilPlayers.remove(currentPlayer);
                    // attention
                    if (players.isEmpty()) {
                        return;
                    }
                    // remove both from list and reference
                    currentPlayer = players.remove(0);
                }
            }
        }
        Deque<String> currentPlayerGunNames = new ArrayDeque<>();
        currentPlayer.getGunRepository().getModels().stream().map(Gun::getName).forEach(currentPlayerGunNames::offer);
        while (true) {
            Gun gun = currentPlayer.getGunRepository().find(currentPlayerGunNames.poll());

            if (gun == null) {
                if(players.isEmpty()){
                    return;
                }
                currentPlayer = players.remove(0);
                currentPlayerGunNames.clear();
                currentPlayer.getGunRepository().getModels().stream().map(Gun::getName).forEach(currentPlayerGunNames::offer);
                continue;
            }

            while (true) {
                int bullets = gun.fire();
                if (bullets == 0) {
                    //we are shure that the weapon is removed
                    currentPlayer.getGunRepository().remove(gun);
                    break;
                }
                mainPlayer.takeLifePoints(bullets);
                if (!mainPlayer.isAlive()) {
                    break;
                }
            }
        }


    }
}
