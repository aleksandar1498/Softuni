import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
public class LogsAggregator {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String,TreeMap<String,Long>> sessionLogs=new TreeMap<>();
        for(int i=0;i<n;i++){
            String [] data=scanner.nextLine().split(" ");
            String user=data[1];
            String ip=data[0];
            Long duration=Long.parseLong(data[2]);
            sessionLogs.putIfAbsent(user,new TreeMap<>());
            if(sessionLogs.get(user).containsKey(ip)){
               sessionLogs.get(user).put(ip,sessionLogs.get(user).get(ip)+duration); 
            }else{
               sessionLogs.get(user).put(ip,duration);  
            }
        }
        sessionLogs.entrySet().forEach(user -> {
            System.out.printf("%s: %d %s%n",user.getKey(),user.getValue().values().stream().reduce(0L,(a,b) -> a+b),user.getValue().keySet().toString());
        });
        
    }
}