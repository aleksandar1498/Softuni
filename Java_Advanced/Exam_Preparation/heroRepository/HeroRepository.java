package heroRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class HeroRepository{
    List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }
    public void add(Hero hero){
        this.data.add(hero);
    }
    public void remove(String name){
        Iterator<Hero> iterator=data.iterator();
       while(iterator.hasNext()){
           if(iterator.next().getName().equals(name)){
               iterator.remove();
               break;
           }
       }
    }
    public Hero getHeroWithHighestStrength(){
        return data.stream().sorted(new ComparatorStrength()).collect(Collectors.toList()).get(0);
       // return this.data.stream().min((h1, h2) -> Integer.compare(h2.getItem().getStrength(), h1.getItem().getStrength())).orElse(null);
    }
    public Hero getHeroWithHighestAgility() {
        return data.stream().sorted(new ComparatorAgility()).collect(Collectors.toList()).get(0);

        //return this.data.stream().min((h1, h2) -> Integer.compare(h2.getItem().getAgility(), h1.getItem().getAgility())).orElse(null);
    }
    public Hero getHeroWithHighestIntelligence()  {
        return data.stream().sorted(new ComparatorIntelligence()).collect(Collectors.toList()).get(0);

        // return this.data.stream().min((h1, h2) -> Integer.compare(h2.getItem().getIntelligence(), h1.getItem().getIntelligence())).orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for (Hero hero : data) {
            builder.append(hero.toString());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
