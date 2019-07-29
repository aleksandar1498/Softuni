import java.util.*;
import java.util.regex.*;
public class PeriodicTable {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        final Set<String> elements=new TreeSet<>();
     
       int n=Integer.parseInt(scanner.nextLine());
       for(int i=0;i<n;i++){
           
           Arrays.stream(scanner.nextLine().split(" ")).forEach(el -> elements.add(el));
           
       }
      
       
           elements.stream().forEach(el -> System.out.print(el+" "));
      
     
    }
}