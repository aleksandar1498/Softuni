package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        //(suspension + durability)
        StringBuilder builder = new StringBuilder(super.toString());
        int i = 1;
        List<Car> finalists=super.getParticipants().stream().sorted((p1,p2) -> Integer.compare(
                (p2.getSuspension() + p2.getDurability()),
                (p1.getSuspension() + p1.getDurability())
        )).limit(3).collect(Collectors.toList());
        for(Car partecipant : finalists){
            int wonMoney=super.getPrizePool();
            int performance = partecipant.getSuspension() + partecipant.getDurability();
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
