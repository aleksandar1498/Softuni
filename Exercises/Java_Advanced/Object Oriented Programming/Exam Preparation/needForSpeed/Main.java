package needForSpeed;

import needForSpeed.cars.Car;
import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;
import needForSpeed.races.CasualRace;
import needForSpeed.races.Race;

public class Main {
    public static void main(String[] args) {
        Car car = new ShowCar("VW","Golf",1998,129,129,21,22);
        Car car1 = new PerformanceCar("VW","Vento",1998,312,2,221,122);
        Car car2 = new PerformanceCar("VW","Passat",1998,42,155,121,232);
Race race = new CasualRace(21,"Montana",100);
race.addPartecipant(car);
        race.addPartecipant(car1);

        race.addPartecipant(car2);

        System.out.println(car);
        System.out.println(race);
    }
}
