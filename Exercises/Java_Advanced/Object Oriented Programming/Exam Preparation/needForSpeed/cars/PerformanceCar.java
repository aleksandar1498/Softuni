package needForSpeed.cars;

import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;
    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability, List<String> addOns) {
        super(brand, model, yearOfProduction, (int)(horsePower*1.25), acceleration, (int)(suspension*.75), durability);
        this.addOns = addOns;
    }

    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }
}
