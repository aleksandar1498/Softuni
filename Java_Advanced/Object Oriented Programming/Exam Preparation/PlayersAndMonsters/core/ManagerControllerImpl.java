package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
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


    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        switch (type) {
            case "Beginner":
                player = new Beginner(new CardRepositoryImpl(), username);
                break;
            case "Advanced":
                player = new Advanced(new CardRepositoryImpl(), username);
                break;
        }
        this.playerRepository.add(player);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, player.getClass().getSimpleName(), player.getUsername());
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        switch (type) {
            case "Magic":
                card = new MagicCard(name);
                break;
            case "Trap":
                card = new TrapCard(name);
                break;
        }
        this.cardRepository.add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = this.playerRepository.find(username);
        Card card = this.cardRepository.find(cardName);
       // Card cardToPass = this.cardRepository.getCards().stream().filter(c -> c.getName().equals(cardName)).findFirst().orElse(null);
        player.getCardRepository().add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);

    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);
        this.battlefield.fight(attacker,enemy);
        return String.format(ConstantMessages.FIGHT_INFO, this.playerRepository.find(attackUser).getHealth(), this.playerRepository.find(enemyUser).getHealth());
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Player player : this.playerRepository.getPlayers()) {
            if (i == 0) {
                builder.append(player.toString());
                i++;
            } else {
                builder.append(System.lineSeparator());
                builder.append(player.toString());
            }
        }

        return builder.toString();
    }
}
