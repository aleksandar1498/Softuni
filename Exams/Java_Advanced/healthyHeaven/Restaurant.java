package healthyHeaven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data=new ArrayList<>();
    }



    public void add(Salad s){
        this.data.add(s);
    }

    public boolean buy(String name){
        Iterator<Salad> saladIterator=this.data.iterator();
        while (saladIterator.hasNext()){
            if(saladIterator.next().getName().equals(name)){
                saladIterator.remove();
                return true;
            }
        }
        return false;
    }
    public Salad getHealthiestSalad(){
        return data.stream().min((s1, s2) -> Integer.compare(s1.getTotalCalories(), s2.getTotalCalories())).orElse(null);
    }

    public String generateMenu() {
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("%s have %d salads:%n",this.name,this.data.size()));
        for(Salad s:data){
            builder.append(s.toString());
        }
        return builder.toString();
    }
}
