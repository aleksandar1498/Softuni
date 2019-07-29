import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
public class PopulationCounter {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       
        Map<String,LinkedHashMap<String,Long>> stat=new LinkedHashMap<>();
        String data="";
        while(!"report".equals(data = scanner.nextLine())){
            
              String [] details=data.split("\\|");
              String city=details[0];
              String country=details[1];
              Long population=Long.parseLong(details[2]);
              stat.putIfAbsent(country,new LinkedHashMap<>());
              stat.get(country).putIfAbsent(city,population);
            
        }
        // reduce is used when we want to reduce the stream to a single element, his behaviour is similar to sum() / average() , but defining the logic is our stuff
       stat.entrySet().stream().sorted((e1,e2) -> {
           Long totPop1=e1.getValue().values().stream().reduce(0L, (a, b) -> a + b);
           Long totPop2=e2.getValue().values().stream().reduce(0L, (a, b) -> a + b);
           return Long.compare(totPop2,totPop1);
       }).forEach(country -> {
           System.out.println(country.getKey()+" (total population: "+country.getValue().values().stream().reduce(0L, (a, b) -> a + b)+")");
           country.getValue().entrySet().stream().sorted((e1,e2) -> {
               return Long.compare(e2.getValue(),e1.getValue());
           }).forEach(city -> System.out.printf("=>%s: %d%n",city.getKey(),city.getValue()));
       });
        
    }
}