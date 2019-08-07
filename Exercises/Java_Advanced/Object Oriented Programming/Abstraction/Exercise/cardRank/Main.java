package cardRank;

public class Main {
    public static void main(String[] args) {
        Card[] cards = Card.values();
        System.out.println("Card Ranks:");
        for (int i = 0; i < cards.length; i++) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",cards[i].val,cards[i]);
        }
    }
}
