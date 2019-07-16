package needForSpeed.cars;

public class ShowCar extends Car {
    private int stars;
    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability, int stars) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
