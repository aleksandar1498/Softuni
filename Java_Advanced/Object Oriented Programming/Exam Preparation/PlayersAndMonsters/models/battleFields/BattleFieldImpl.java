package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    public BattleFieldImpl() {
    }

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if(attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }
        if(attackPlayer.getClass().getSimpleName().equals("Beginner")){
            attackPlayer.setHealth(attackPlayer.getHealth()+40);
            attackPlayer.getCardRepository().getCards().forEach(c -> c.setDamagePoints(c.getDamagePoints()+30));
        }
        if(enemyPlayer.getClass().getSimpleName().equals("Beginner")){
            enemyPlayer.setHealth(enemyPlayer.getHealth()+40);
            enemyPlayer.getCardRepository().getCards().forEach(c -> c.setDamagePoints(c.getDamagePoints()+30));
        }
        enemyPlayer.getCardRepository().getCards().forEach(c -> {
            enemyPlayer.setHealth(enemyPlayer.getHealth()+c.getHealthPoints());
        });

        attackPlayer.getCardRepository().getCards().forEach(c -> {
            attackPlayer.setHealth(attackPlayer.getHealth()+c.getHealthPoints());
        });
        while (true){
            enemyPlayer.takeDamage(attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum());
            if(enemyPlayer.isDead()){
               break;
            }
            attackPlayer.takeDamage(enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum());
            if(attackPlayer.isDead()){
                break;
            }
        }

    }

}
