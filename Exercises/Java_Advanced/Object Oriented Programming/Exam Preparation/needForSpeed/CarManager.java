package needForSpeed;

import needForSpeed.cars.Car;
import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;
import needForSpeed.garage.Garage;
import needForSpeed.races.CasualRace;
import needForSpeed.races.DragRace;
import needForSpeed.races.DriftRace;
import needForSpeed.races.Race;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CarManager {
    private Garage garage;
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;

    public CarManager() {
        this.garage = new Garage();
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        if (type.equals("Show")) {
            car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        } else if (type.equals("Performance")) {
            car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        }
        System.out.println();
        if (car != null) {
            this.cars.putIfAbsent(id, car);
        }

    }

    public String check(int id) {
        if (this.cars.containsKey(id)) {
            return this.cars.get(id).toString();
        }
        return "";
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
        }
        if (race != null) {
            this.races.putIfAbsent(id, race);
        }
    }

    public void participate(int carId, int raceId) {
        if (this.cars.containsKey(carId) && this.races.containsKey(raceId)) {
            Car c = this.cars.get(carId);
            // if the car is not parked and the race is opened the participant can be added
            if (!this.garage.getParkedCars().contains(c) && this.races.get(raceId).isOpened()) {
                this.races.get(raceId).addPartecipant(c);
            }
        }
    }

    public String start(int id) {
        if (this.races.containsKey(id)) {
            // check if there is at least one participant
            if (this.races.get(id).getParticipants().size() > 0) {
                this.races.get(id).setOpened(false);
                return this.races.get(id).toString();
            }
            return "Cannot start the race with zero participants.";
        }
        return "";
    }

    public void park(int id) {
        if (!this.cars.containsKey(id)) {
            return;
        }
        Car c = this.cars.get(id);
        if (this.garage.getParkedCars().contains(c)) {
            return;
        }
        for (Race race : this.races.values()) {
            // if the car is part of a race but the race is closed it can be parked
            if (race.getParticipants().contains(c) && !race.isOpened()) {
                this.garage.park(c);
                return;
            }
        }
        // the car is not part of a race so we can park it
        this.garage.park(c);

    }


    public void unpark(int id) {
        if (this.cars.containsKey(id)) {
            this.garage.unpark(this.cars.get(id));
        }

    }

    public void tune(int tuneIndex, String addOn) {
        if (this.garage.getParkedCars().size() > 0) {
            // horsepower by the given index, and the suspension, by HALF of the given index
            for (Car parkedCar : this.garage.getParkedCars()) {
                parkedCar.setHorsePower(parkedCar.getHorsePower() + tuneIndex);
                parkedCar.setSuspension(parkedCar.getSuspension() + (tuneIndex / 2));
                if (parkedCar instanceof ShowCar) {
                    ((ShowCar) parkedCar).setStars(((ShowCar) parkedCar).getStars() + tuneIndex);
                } else if (parkedCar instanceof PerformanceCar) {
                    ((PerformanceCar) parkedCar).addAddOn(addOn);
                }
            }
        }
    }

}
