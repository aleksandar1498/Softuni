import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
public class LogsAggregator {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       Pattern pattern = Pattern.compile("(?<singer>[A-Za-z\\s]+) @(?<venue>[A-Za-z\\s]+) (?<price>[0-9]+) (?<bought>[0-9]+)");
       String line="";
       Map<String,LinkedHashMap<String,Integer>> venues=new LinkedHashMap<>(); 
       while(!"End".equals(line = scanner.nextLine())){
           Matcher m=pattern.matcher(line);
            
           if(m.find()){
               String singer=m.group("singer");
               String venue=m.group("venue");
               int price=Integer.parseInt(m.group("price"));
               int  totTickets=Integer.parseInt(m.group("bought"));
               int totEarned=price*totTickets;
              
               venues.putIfAbsent(venue,new LinkedHashMap<>());
              
               if(venues.get(venue).containsKey(singer)){
                   venues.get(venue).put(singer,venues.get(venue).get(singer)+totEarned);
               }else{
                   venues.get(venue).put(singer,totEarned);
               }
               
           }
       }
       venues.entrySet().stream().forEach(venue -> {
           System.out.println(venue.getKey());
           venue.getValue().entrySet().stream().sorted((e1,e2) -> {
               return Integer.compare(e2.getValue(),e1.getValue());
           }).forEach(s -> System.out.printf("#  %s -> %d%n",s.getKey(),s.getValue()));
           
       });
       
        
    }
}