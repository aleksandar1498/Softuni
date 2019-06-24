package hotelReservation;

public enum Discount {
    VIP(20), SecondVisit(10), None(0);
    int discountVal;

    Discount(int discountVal) {
        this.discountVal = discountVal;
    }
}
