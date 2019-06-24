package cardSuit;

public enum  Card {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);
    int val;

    Card(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
