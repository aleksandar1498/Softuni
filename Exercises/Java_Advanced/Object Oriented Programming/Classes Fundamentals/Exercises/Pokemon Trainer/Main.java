import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Set<Trainer> trainers=new LinkedHashSet<>();
        String line="";
        while(!"Tournament".equals(line = scanner.nextLine())){
            String [] trainerToken=line.split(" ");
            String name=trainerToken[0];
            String pokemonName=trainerToken[1];
            String pokemonType=trainerToken[2];
            int pokemonHealth=Integer.parseInt(trainerToken[3]);
            Trainer current=new Trainer(name);
            if(!trainers.contains(current)){
                trainers.add(current);
            }
            for(Trainer t:trainers){
                if(t.name.equals(current.name)){
                    t.getPokemons().add(new Pokemon(pokemonName,pokemonType,pokemonHealth));
                }
             }
            
            
        }
        String trainEl="";
        while(!"End".equals(trainEl = scanner.nextLine())){
         for(Trainer t:trainers){
             t.trainPokemons(trainEl);
         }
        }
        trainers.stream().sorted((e1,e2) ->{
            return Integer.compare(e2.getBadges(),e1.getBadges());
        }).forEach(t -> System.out.println(t.name+" "+t.getBadges()+" "+t.getPokemons().size()));
       
    }
}