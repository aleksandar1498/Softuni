package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DragRace extends  Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        // (horsepower / acceleration)
        StringBuilder builder = new StringBuilder(super.toString());
        int i = 1;
        List<Car> finalists=super.getParticipants().stream().limit(3).sorted((p1,p2) -> Integer.compare(
                (p2.getHorsePower() / p2.getAcceleration()),
                (p1.getHorsePower() / p1.getAcceleration())
        )).collect(Collectors.toList());
        for(Car partecipant : finalists){
            int wonMoney=super.getPrizePool();
            int performance = (partecipant.getHorsePower() / partecipant.getAcceleration());
            if(i == 1){
                wonMoney*=.5;
            }else if(i == 2){
                wonMoney*=.3;
            }else{
                wonMoney*=.2;
            }
            builder.append(System.lineSeparator());
            builder.append(String.format("%d. %s %s %dPP - $%d",i,partecipant.getBrand(),partecipant.getModel(),performance,wonMoney));
            i++;
        }
        return builder.toString();
    }
}
