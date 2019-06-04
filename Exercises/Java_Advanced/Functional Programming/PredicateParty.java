import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class PredicateParty {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        List<String> guests=new ArrayList<>();
        guests.addAll(Arrays.asList(scanner.nextLine().split(" ")));
        String command="";
        while(!"Party!".equals(command = scanner.nextLine())){
            //System.out.println(command);
            String [] commandToken=command.split(" ");
            switch(commandToken[0]){
                case "Remove":
                    if(commandToken[1].equals("StartsWith")){
                        guests.removeAll(startsWith(guests,commandToken[2]));
                    }else if(commandToken[1].equals("EndsWith")){
                        guests.removeAll(endsWith(guests,commandToken[2]));
                    }else{
                        guests.removeAll(isLength(guests,commandToken[2]));
                    }
                    break;
                case "Double":
                     if(commandToken[1].equals("StartsWith")){
                        guests.addAll(startsWith(guests,commandToken[2]));
                    }else if(commandToken[1].equals("EndsWith")){
                        guests.addAll(endsWith(guests,commandToken[2]));
                    }else{
                        guests.addAll(isLength(guests,commandToken[2]));
                    }
                    break;
            }
        }
        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }
        Collections.sort(guests);
        
            System.out.println(guests.toString().replaceAll("[\\[\\]]","")+" are going to the party!");
        
       
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
   
}