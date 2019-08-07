import java.util.*;
import java.util.regex.*;
public class UniqueUsernames {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Set<String> usernameSet=new LinkedHashSet<>();
     
       int n=Integer.parseInt(scanner.nextLine());
       for(int i=0;i<n;i++){
           usernameSet.add(scanner.nextLine());
       }
      
       
           usernameSet.stream().forEach(System.out::println);
      
     
    }
}