package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public BasePlayer(String username, int health, CardRepository cardRepository) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        this.isDead = false;
    }


    private void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
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
    public void setHealth(int healthPoints) {
        if(healthPoints < 0){
            if(this.username.isEmpty() || this.username.matches("\\s+")){
                throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
            }
        }
            this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if(damagePoints < 0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        if((this.getHealth() - damagePoints) < 0){
            this.setDead(true);
            return;
        }
        this.setHealth(this.getHealth()-damagePoints);
    }

    private void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Username: %s - Health: %d – Cards %d",this.getUsername(),this.getHealth(),this.getCardRepository().getCount()));
        this.getCardRepository().getCards().forEach(b -> {
            builder.append(System.lineSeparator()).append(b.toString());
        });
        builder.append(System.lineSeparator()).append("###");
        return builder.toString();
    }
}
