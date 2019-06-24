package hotelReservation;

public class PriceCalculator {
    static double calculatePrice(double pricePerDay,int numberOfDays,Season season,Discount discount){
        double basePrice=pricePerDay*numberOfDays;
        basePrice*=season.getValue();
        basePrice*=1-(discount.discountVal/100.0);
        return basePrice;
    }
}
