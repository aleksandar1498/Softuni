package softUniParking;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    Map<String, Car> cars;
    int capacity;

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Parking(int capacity) {
        this.capacity = capacity;
        cars = new LinkedHashMap<>();
    }

    public String addCar(Car c) {
        if (this.cars.containsKey(c.registrationNumber)) {
            return "Car with that registration number, already exists!";
        } else if (this.cars.size() >= this.capacity) {
            return "Parking is full!";
        } else {
            cars.put(c.registrationNumber, c);
            return String.format("Successfully added new car %s %s", c.getMake(), c.getRegistrationNumber());
        }
    }

    public String removeCar(String registrationNumber) {
        if (cars.containsKey(registrationNumber)) {

            cars.remove(registrationNumber);
            return String.format("Successfully removed %s", registrationNumber);

        } else {

            return "Car with that registration number, doesn't exists!";
        }
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String registrationNumber : registrationNumbers) {
            this.cars.remove(registrationNumber);
        }
    }

    public int getCount() {
        return this.cars.size();
    }
}
