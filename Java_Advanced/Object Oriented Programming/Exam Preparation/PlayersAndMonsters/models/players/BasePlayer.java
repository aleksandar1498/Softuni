package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.DEFAULT_REPORT_SEPARATOR;
import static common.ConstantMessages.PLAYER_REPORT_INFO;

public abstract class BasePlayer implements Player {
    private CardRepository cardRepository;
    private String username;
    private int health;
    private boolean isDead;


    public BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.isDead = false;
    }


    private void setUsername(String username)  throws IllegalArgumentException{
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }



    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints)  throws IllegalArgumentException{
        if (healthPoints < 0) {

            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");

        }
        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints)  throws IllegalArgumentException{
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        if ((this.getHealth() - damagePoints) < 0) {
            this.setHealth(0);
            this.isDead=true;
            return;
        }
        this.setHealth(this.getHealth() - damagePoints);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(PLAYER_REPORT_INFO, this.getUsername(), this.getHealth(), this.getCardRepository().getCount()));
        this.getCardRepository().getCards().forEach(b -> {
            builder.append(System.lineSeparator()).append(b.toString());
        });
        builder.append(System.lineSeparator()).append(DEFAULT_REPORT_SEPARATOR);
        return builder.toString();
    }
}
