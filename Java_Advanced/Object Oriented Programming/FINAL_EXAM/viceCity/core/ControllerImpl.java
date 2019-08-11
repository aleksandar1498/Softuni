package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Neighbourhood neighbourhood;
    private Map<String, Player> players;
    private ArrayDeque<Gun> guns;

    public ControllerImpl() {
        this.neighbourhood = new GangNeighbourhood();
        this.players = new LinkedHashMap<>();
        this.players.put("Vercetti", new MainPlayer());
        this.guns = new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        if (!this.players.containsKey(name)) {
            this.players.put(name, new CivilPlayer(name));
        }
        return String.format("Successfully added civil player: %s!", name);
    }

    @Override
    public String addGun(String type, String name) {
        if (!type.equals("Pistol") && !type.equals("Rifle")) {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        Gun gun = null;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        }
        this.guns.offer(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.guns.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (!this.players.containsKey(name)) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        Gun gun = this.guns.poll();
        this.players.get(name).getGunRepository().add(gun);
        if (name.equals("Vercetti")) {
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        }
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);

    }

    @Override
    public String fight() {
        if (this.players.get("Vercetti").getGunRepository().getModels().isEmpty()) {
            return "Everything is okay!";
        }
        List<Player> civils = this.players.values().stream().filter(x -> !x.getName().equals("Vercetti")).collect(Collectors.toList());
        int aliveCivils = civils.size();
        this.neighbourhood.action(this.players.get("Vercetti"), civils);
        // System.out.println(this.players.get("Vercetti").isAlive());
        return String.format("A fight happened:\n" +
                        "Tommy live points: %d!\n" +
                        "Tommy has killed: %d players!\n" +
                        "Left Civil Players: %d!",
                this.players.get("Vercetti").getLifePoints()
                , (aliveCivils - civils.size())
                , civils.size());
    }
}
