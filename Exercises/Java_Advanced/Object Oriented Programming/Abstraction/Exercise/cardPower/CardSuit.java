package CardPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    int val;

    CardSuit(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
