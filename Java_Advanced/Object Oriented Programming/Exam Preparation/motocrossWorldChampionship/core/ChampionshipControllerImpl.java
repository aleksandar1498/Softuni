package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.stream.Collectors;

public class ChampionshipControllerImpl implements ChampionshipController {
    private Repository<Rider> riders;
    private Repository<Motorcycle> motorcycles;
    private Repository<Race> races;

    ChampionshipControllerImpl() {
        this.riders = new RiderRepository();
        this.motorcycles = new MotorcycleRepository();
        this.races = new RaceRepository();
    }

    @Override
    public String createRider(String riderName) {
        this.riders.add(new RiderImpl(riderName));
        return String.format(OutputMessages.RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle motorcycle = null;
        if(this.motorcycles.getAll().stream().anyMatch(x -> x.getModel().equals(model))){
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS,model));
        }
        switch (type) {
            case "Power":
                motorcycle = new PowerMotorcycle(model, horsePower);
                break;
            case "Speed":
                motorcycle = new SpeedMotorcycle(model, horsePower);
                break;
        }
        this.motorcycles.add(motorcycle);
        return String.format(OutputMessages.MOTORCYCLE_CREATED, type+"Motorcycle", model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        this.riders.getByName(riderName).addMotorcycle(this.motorcycles.getByName(motorcycleModel));
        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        this.races.getByName(raceName).addRider(this.riders.getByName(riderName));
        return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.races.getByName(raceName);
        if (race.getRiders().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }
        int i = 1;
        StringBuilder builder = new StringBuilder();
        for (Rider rider : race.getRiders().stream().sorted((r1, r2) -> {
            return Double.compare(r2.getMotorcycle().calculateRacePoints(race.getLaps()), r1.getMotorcycle().calculateRacePoints(race.getLaps()));
        }).limit(3).collect(Collectors.toList())) {
            switch (i){
                case 1:
                    builder.append(String.format(OutputMessages.RIDER_FIRST_POSITION,rider.getName(),race.getName()));
                    builder.append(System.lineSeparator());
                    break;
                case 2:
                    builder.append(String.format(OutputMessages.RIDER_SECOND_POSITION,rider.getName(),race.getName()));
                    builder.append(System.lineSeparator());
                    break;
                case 3:
                    builder.append(String.format(OutputMessages.RIDER_THIRD_POSITION,rider.getName(),race.getName()));

                    break;
            }

            i++;

        }
        return builder.toString();
    }

    @Override
    public String createRace(String name, int laps){
        this.races.add(new RaceImpl(name, laps));
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
