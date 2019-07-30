import java.util.*;
import java.util.stream.*;
public class VideoLogger {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        String line="";
        Map<String,Vlogger> vloggers=new LinkedHashMap<>();
        while(!"Statistics".equals(line = scanner.nextLine())){
            String [] token=line.split(" ");
            switch(token[1]){
                case "joined":
                    vloggers.putIfAbsent(token[0],new Vlogger());
                    break;
                case "followed":
                    if(vloggers.containsKey(token[0]) && vloggers.containsKey(token[2]) && !token[0].equals(token[2])){
                        vloggers.get(token[0]).following.add(token[2]);
                        vloggers.get(token[2]).followers.add(token[0]);
                    }
                    break;
            }
        }
        vloggers = vloggers.entrySet().stream().sorted((e1,e2) -> {
           int sort=Integer.compare(e2.getValue().followers.size(),e1.getValue().followers.size());
           if(sort == 0){
               sort = Integer.compare(e1.getValue().following.size(),e2.getValue().following.size());
           }
           return sort;
        }).collect(Collectors.toMap(x -> x.getKey(),
											x -> x.getValue(),
											(oldValue, newValue) -> newValue,
											LinkedHashMap::new));
		vloggers.forEach(Syste)
        
    }
    static class Vlogger{
        Set<String> followers;
        Set<String> following;
        
        public Vlogger(){
            this.followers=new LinkedHashSet<>();
            this.following=new LinkedHashSet<>();
        }
    }
}