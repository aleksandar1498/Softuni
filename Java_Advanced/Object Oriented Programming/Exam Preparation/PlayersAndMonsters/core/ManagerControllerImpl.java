package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import java.lang.reflect.InvocationTargetException;


public class ManagerControllerImpl implements ManagerController {
    private CardRepository cardRepository;
    private PlayerRepository playerRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.cardRepository = new CardRepositoryImpl();
        this.playerRepository = new PlayerRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    private CardRepository getCardRepository() {
        return cardRepository;
    }

    private PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    @Override
    public String addPlayer(String type, String username) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Player> clazz = (Class<Player>) Class.forName(type);
        Player player = clazz.getDeclaredConstructor(String.class).newInstance(username);
        this.getPlayerRepository().add(player);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, player.getClass().getSimpleName(), player.getUsername());
    }

    @Override
    public String addCard(String type, String name) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Card> clazz = (Class<Card>) Class.forName(type);
        Card card = clazz.getDeclaredConstructor(String.class).newInstance(name);
        this.getCardRepository().add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, card.getClass().getSimpleName(), card.getName());
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        if (this.getCardRepository().getCards().stream().anyMatch(c -> c.getName().equals(cardName))
                && this.getPlayerRepository().getPlayers().stream().anyMatch(p -> p.getUsername().equals(username))) {
            this.getPlayerRepository().find(username).getCardRepository().add(this.getCardRepository().find(cardName));
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, cardName, username);
        }
        return "Operation failed";
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        //  "Attack user health {attack player} - Enemy user health {enemy player}"
        if (this.getPlayerRepository().find(attackUser) != null && this.getPlayerRepository().find(enemyUser) != null) {
            this.battlefield.fight(this.getPlayerRepository().find(attackUser), this.getPlayerRepository().find(enemyUser));
            return String.format(ConstantMessages.FIGHT_INFO,this.getPlayerRepository().find(attackUser).getHealth(), this.getPlayerRepository().find(enemyUser).getHealth());
        }
        return "Operation failed";
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        this.getPlayerRepository().getPlayers().forEach(p -> {
            builder.append(System.lineSeparator());
            builder.append(p.toString());
        });
        return builder.toString();
    }
}
