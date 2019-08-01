package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card)  throws IllegalArgumentException{
     if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        if (this.getCards().stream().anyMatch(c -> c.getName().equals(card.getName()))) {
            throw new IllegalArgumentException("Card " + card.getName() + " already exists!");
        }
        this.getCards().add(card);
    }


    @Override
    public boolean remove(Card card)  throws IllegalArgumentException{
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
