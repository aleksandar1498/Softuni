import java.util.*;
import java.util.regex.*;
public class CountSymbols {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        final Map<Character,Integer> symbols=new HashMap<>();
          char [] symbs= scanner.nextLine().toCharArray();
          for(int i=0;i<symbs.length;i++){
              if(!symbols.containsKey(symbs[i])){
                   symbols.put(symbs[i],1);
               }else{
                   symbols.put(symbs[i],symbols.get(symbs[i])+1);
               }
          }
         
           symbols.entrySet().stream().sorted((e1,e2) -> {
               return e1.getKey().compareTo(e2.getKey());
           }).forEach(s -> System.out.printf("%s: %d time/s%n",s.getKey(),s.getValue()));
      
     
    }
}