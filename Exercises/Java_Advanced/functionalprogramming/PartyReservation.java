import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class PartyReservation {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        List<String> guests=new ArrayList<>();
        Map<String,LinkedList<String>> filters=new LinkedHashMap<>(); 
        guests.addAll(Arrays.asList(scanner.nextLine().split(" ")));
        String command="";
        while(!"Print".equals(command = scanner.nextLine())){
            //System.out.println(command);
            String [] commandToken=command.split(";");
            String filterName=commandToken[1];
            String filterVal=commandToken[2];
            switch(commandToken[0]){
                case "Add filter":
                    filters.putIfAbsent(filterName,new LinkedList<>());
                    if(!filters.get(filterName).contains(filterVal)){
                        filters.get(filterName).add(filterVal);
                    }
                    break;
                case "Remove filter":
                    if(filters.containsKey(filterName)){
                        if(filters.get(filterName).contains(filterVal)){
                           filters.get(filterName).remove(filterVal);
                        }
                    }
                    break;
            }
           
        }
        for(Map.Entry<String,LinkedList<String>> filter : filters.entrySet()){
           String criteria = filter.getKey();
            
            for(String val : filter.getValue()){
                if(criteria.equals("StartsWith")){
                    guests.removeAll(startsWith(guests,val));
                }else if(criteria.equals("EndsWith")){
                    guests.removeAll(endsWith(guests,val));
                }else if(criteria.equals("Length")){
                    guests.removeAll(isLength(guests,val));
                }else{
                     guests.removeAll(isContaining(guests,val));    
                }
            }
        }
       
        System.out.println(guests.toString().replaceAll("[\\[\\],]",""));
       
        
       
    }
    public static List<String> endsWith(List<String> guests,String compare){
        Predicate<String> ends = a -> a.endsWith(compare);
        Function<String,Boolean> endsWith= name -> ends.test(name);
        return guests.stream().filter(val -> endsWith.apply(val)).collect(Collectors.toList());
    }
     
    public static List<String> startsWith(List<String> guests,String compare){
        Predicate<String> starts = a -> a.startsWith(compare);
         Function<String,Boolean> startsWith= name -> starts.test(name);
        return guests.stream().filter(val -> startsWith.apply(val)).collect(Collectors.toList());
    }
    
    public static List<String> isLength(List<String> guests,String compareLength){
        Predicate<String> sameLength = a -> a.length() == Integer.parseInt(compareLength);
        Function<String,Boolean> lengthFun= name -> sameLength.test(name);
        return guests.stream().filter(val -> lengthFun.apply(val)).collect(Collectors.toList());
    }
    public static List<String> isContaining(List<String> guests,String word){
        Predicate<String> containsWord = a -> a.contains(word);
        Function<String,Boolean> wordPresence= name -> containsWord.test(name);
        return guests.stream().filter(val -> wordPresence.apply(val)).collect(Collectors.toList());
    }
   
}