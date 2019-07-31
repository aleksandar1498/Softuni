package models.commands;

import annotations.Inject;
import exceptions.*;
import interfaces.boats.Boat;
import interfaces.races.Race;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StartRace extends Command{
    @Inject
    Race race;

    protected StartRace(String[] data) {
        super(data);
    }

    private Race getRace() {
        return race;
    }

    @Override
    public String execute() throws NoSetRaceException, InsufficientContestantsException {
        if(!this.getRace().isOpen()){
            throw new NoSetRaceException();
        }
        if(this.getRace().getParticipants().count() < 3){
            throw new InsufficientContestantsException();
        }

        StringBuilder builder = new StringBuilder();
        // removing participants
        String [] classification = { "First place:","Second place:","Third place:"};
        DecimalFormat df = new DecimalFormat("######.##");
        int i = 0 ;
        for (Boat boat : this.getRace().getParticipants().getEntries().values()
                .stream()
                .sorted(Comparator.comparingDouble(b -> {
                    if (b.getSpeed(this.getRace()) == Double.MAX_VALUE) {
                        return b.getSpeed(this.getRace());
                    }
                    return this.getRace().getDistance() / b.getSpeed(this.getRace());
                })).collect(Collectors.toList())) {
            builder.append(String.format("%s %s Model: %s Time: %s%n",classification[i],boat.getClass().getSimpleName(),boat.getModel(),(boat.getSpeed(this.getRace()) == Double.MAX_VALUE)?"Did not finish!":df.format(this.getRace().getDistance() / boat.getSpeed(this.getRace()))+" sec"));
            i++;
        }
            //    .forEach(boat -> System.out.println(boat.getModel()+" "+this.getRace().getDistance()/boat.getSpeed(this.getRace())));
        this.getRace().getParticipants().clearRepo();
        this.getRace().close();
        return builder.toString();
    }
}
