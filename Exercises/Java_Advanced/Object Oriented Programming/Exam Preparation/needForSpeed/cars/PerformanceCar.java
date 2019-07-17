package needForSpeed.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;
    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, (int)(horsePower*1.25), acceleration, (int)(suspension*.75), durability);
        this.addOns = new ArrayList<>();
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(addOns);
    }

    @Override
    public String toString() {
        return String.format("%s%nAdd-ons: %s",super.toString(),(this.getAddOns().size() > 0)?String.join(", ",this.getAddOns()):"None");
    }
}
