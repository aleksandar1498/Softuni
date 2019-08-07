package needForSpeed.garage;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(parkedCars);
    }
    public void park(Car c){
        this.parkedCars.add(c);
    }
    public void unpark(Car c){
        this.parkedCars.remove(this.parkedCars.indexOf(c));
    }


    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }
}
