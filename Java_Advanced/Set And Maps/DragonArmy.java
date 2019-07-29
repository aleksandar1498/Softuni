import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
public class DragonArmy {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());        Map<String,TreeMap<String,LinkedList<Integer>>> dragons=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String [] dragonDetails=scanner.nextLine().split(" ");
            String type=dragonDetails[0];
            String name=dragonDetails[1];
            int damage=dragonDetails[2].equals("null")? 45 : Integer.parseInt(dragonDetails[2]);
            int health=dragonDetails[3].equals("null")? 250 : Integer.parseInt(dragonDetails[3]);
            int armor=dragonDetails[4].equals("null")? 10 : Integer.parseInt(dragonDetails[4]);
            dragons.putIfAbsent(type,new TreeMap<>());
            dragons.get(type).put(name,new LinkedList<>());
            dragons.get(type).get(name).add(damage);
            dragons.get(type).get(name).add(health);
            dragons.get(type).get(name).add(armor);        }
   
        dragons.entrySet().forEach(type -> {
           
            int sumDamage=0;
            int sumHealth=0;
            int sumArmor=0;
            int count=type.getValue().values().size();
            for(LinkedList<Integer> val:type.getValue().values()){
                sumDamage+=val.get(0);
                sumHealth+=val.get(1);
                sumArmor+=val.get(2);
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",type.getKey(),(double)sumDamage/count,(double)sumHealth/count,(double)sumArmor/count);
            type.getValue().entrySet().stream().forEach(dragon -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",dragon.getKey(),dragon.getValue().get(0),dragon.getValue().get(1),dragon.getValue().get(2)));           
        });
        
    }
}