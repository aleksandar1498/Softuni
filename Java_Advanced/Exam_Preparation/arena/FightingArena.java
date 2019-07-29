package arena;

import java.util.LinkedHashMap;
import java.util.Map;

public class FightingArena {
    Map<String,Gladiator> gladiators;
    String name;

    public String getName() {
        return name;
    }

    public FightingArena(String name) {
        this.name=name;
        this.gladiators = new LinkedHashMap<>();
    }
    public void add(Gladiator g){
        if(!gladiators.containsKey(g.getName())){
            this.gladiators.put(g.getName(),g);
        }
    }
    public void remove(String name){
        gladiators.remove(name);
    }
    public Gladiator getGladiatorWithHighestStatPower(){
        return gladiators.entrySet().stream().min((g1, g2) -> Integer.compare(g2.getValue().getStatPower(), g1.getValue().getStatPower())).orElse(null).getValue();
    }
    public Gladiator getGladiatorWithHighestWeaponPower(){
        return gladiators.entrySet().stream().min((g1, g2) -> Integer.compare(g2.getValue().getWeaponPower(), g1.getValue().getWeaponPower())).orElse(null).getValue();
    }
    public Gladiator getGladiatorWithHighestTotalPower(){
        return gladiators.entrySet().stream().min((g1, g2) -> Integer.compare(g2.getValue().getTotalPower(), g1.getValue().getTotalPower())).orElse(null).getValue();
    }
    public int getCount(){
        return this.gladiators.size();

    }
    @Override
    public String toString() {
        return this.getName()+" - "+this.getCount()+" gladiators are participating.";
    }
}
