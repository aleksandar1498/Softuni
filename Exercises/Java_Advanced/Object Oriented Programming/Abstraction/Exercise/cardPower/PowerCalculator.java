package CardPower;

public class PowerCalculator {
    public static int calculateCardPower(CardRank cardRank,CardSuit cardSuit){
        return cardRank.getVal()+cardSuit.getVal();
    }
}
