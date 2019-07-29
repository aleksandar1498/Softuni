import java.util.*;
import java.util.regex.*;
public class SoftuniParty {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       
        Set<String> vip=new  TreeSet<>();
        Set<String> regular=new  TreeSet<>();
        String input="";
        while(!"PARTY".equals(input = scanner.nextLine())){
           if(input.length() == 8){
               if(Character.isDigit(input.charAt(0))){
                  
                   vip.add(input);
                   
               }else{
                   
                   regular.add(input);
                   
               }
           }
        }
        
     while(!"END".equals(input = scanner.nextLine())){
            if(input.length() == 8){
               if(Character.isDigit(input.charAt(0))){
                 
                   vip.remove(input);
                   
               }else{
                  
                   regular.remove(input);
                   
               }
           }
        }
        System.out.println(vip.size()+regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    
        
    }
}