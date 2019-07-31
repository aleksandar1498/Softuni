package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    @Override
    public int getCount() {
        return this.getCards().size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
     if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        if (this.getCards().stream().anyMatch(c -> c.getName().equals(card.getName()))) {
            throw new IllegalArgumentException("Card " + card.getName() + " already exists!");
        }
        this.getCards().add(card);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean remove(Card card) {
        if(card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        return this.getCards().remove(card);
    }

    @Override
    public Card find(String name) {
        return this.getCards().stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
