package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private boolean opened;
    private List<Car> participants ;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
        this.opened = true;
    }
    public void addPartecipant(Car c){
        this.participants.add(c);
    }

    public int getLength() {
        return length;
    }


    public String getRoute() {
        return route;
    }



    public int getPrizePool() {
        return prizePool;
    }


    public List<Car> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return this.getRoute()+" - "+this.getLength();
    }
}
