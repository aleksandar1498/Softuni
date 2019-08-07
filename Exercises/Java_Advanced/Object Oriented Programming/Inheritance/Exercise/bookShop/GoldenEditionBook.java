package bookShop;

public class GoldenEditionBook extends Book {
    private static final double INCREASE_PRICE_VAL=1.3;
    public GoldenEditionBook(String author,String title,  double price) {
        super( author,title, price*INCREASE_PRICE_VAL);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
