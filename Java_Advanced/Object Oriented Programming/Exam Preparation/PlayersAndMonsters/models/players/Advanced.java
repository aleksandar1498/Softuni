package models.players;

import repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer{
    private static final int DEFAULT_HEALTH_POINTS=250;
    public Advanced(String username, CardRepository cardRepository) {
        super(username, DEFAULT_HEALTH_POINTS, cardRepository);
    }
}
