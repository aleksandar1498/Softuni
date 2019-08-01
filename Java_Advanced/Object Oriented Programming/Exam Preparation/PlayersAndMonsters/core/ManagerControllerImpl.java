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


    @Override
    public String addPlayer(String type, String username) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Player> clazz = (Class<Player>) Class.forName("models.players."+type);
        Player player = clazz.getDeclaredConstructor(CardRepository.class,String.class).newInstance(new CardRepositoryImpl(),username);
        this.playerRepository.add(player);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, player.getClass().getSimpleName(), player.getUsername());
    }

    @Override
    public String addCard(String type, String name) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Card> clazz = (Class<Card>) Class.forName("models.cards."+type+"Card");
        Card card = clazz.getDeclaredConstructor(String.class).newInstance(name);
        this.cardRepository.add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, card.getClass().getSimpleName().replaceAll("Card",""), card.getName());
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        if (this.cardRepository.getCards().stream().anyMatch(c -> c.getName().equals(cardName))
                && this.playerRepository.getPlayers().stream().anyMatch(p -> p.getUsername().equals(username))) {
            this.playerRepository.find(username).getCardRepository().add(this.cardRepository.find(cardName));
            System.out.println();
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
        }
        return "Operation failed";
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        //  "Attack user health {attack player} - Enemy user health {enemy player}"
        if (this.playerRepository.find(attackUser) != null && this.playerRepository.find(enemyUser) != null) {
            this.battlefield.fight(this.playerRepository.find(attackUser), this.playerRepository.find(enemyUser));
            return String.format(ConstantMessages.FIGHT_INFO, this.playerRepository.find(attackUser).getHealth(), this.playerRepository.find(enemyUser).getHealth());
        }
        return "Operation failed";
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        this.playerRepository.getPlayers().forEach(p -> {
            builder.append(System.lineSeparator());
            builder.append(p.toString());
        });
        return builder.toString();
    }
}
