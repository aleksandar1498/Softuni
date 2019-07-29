import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
public class UserLogs {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       
        Map<String,LinkedHashMap<String,Integer>> logs=new TreeMap<>();
        String log="";
        while(!"end".equals(log = scanner.nextLine())){
            
          
                String ip=log.split(" ")[0].split("=")[1].trim();
                String user=log.split(" ")[2].split("=")[1].trim();
                // presence user
                logs.putIfAbsent(user,new LinkedHashMap<>());
                
                    // if user has already sent from this ip
                if(logs.get(user).containsKey(ip)){
                   logs.get(user).put(ip,logs.get(user).get(ip)+1); 
                }else{
                    logs.get(user).put(ip,1); 
                }
               
               
            
        }
        logs.entrySet().stream().forEach(user -> {
            System.out.println(user.getKey()+":");
            System.out.println(user.getValue().entrySet().stream().map(o -> o.getKey()+" => "+o.getValue()).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]","")+".");
           
        });
        
    }
}