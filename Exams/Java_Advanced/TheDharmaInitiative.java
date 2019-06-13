import java.util.*;
import java.util.stream.*;
public class DharmaInitiative {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        List<String> stationNames=new ArrayList(Arrays.asList("Hydra","Arrow","Flame","Pearl","Orchid"));
        List<String> description=new ArrayList(Arrays.asList(
            "Zoological Research.",
            "Development of defensive strategies, and Intelligence gathering.",
            "Communication.",
            "Psychological Research and/or Observation.",
            "Space-time manipulation research, disguised as a Botanical station."));
        Map<String,String> stationDetails=new LinkedHashMap<>();
        for(int i=0;i<stationNames.size();i++){
            stationDetails.put(stationNames.get(i),description.get(i));
        }
        Map<String,LinkedHashMap<Integer,String>> stations=new LinkedHashMap<>();
        for(String name:stationNames){
            stations.put(name,new LinkedHashMap<>());
        }
        //stations.entrySet().stream().forEach(s -> System.out.println(s.getKey()));
       String input="";
        while(!"Recruit".equals(input = scanner.nextLine())){
            String [] data=input.split(":");
            String stationName=data[2];
            int fNum=Integer.parseInt(data[1]);
            String personName=data[0];
            if(stations.containsKey(stationName)){
                if(!stations.get(stationName).containsKey(fNum)){
                    stations.get(stationName).put(fNum,personName);
                }
            }
            
        }
        String command=scanner.nextLine();
        if(command.equals("DHARMA Initiative")){
             stations.entrySet().stream().sorted((s1,s2) -> {
                    int sort=Integer.compare(s2.getValue().size(),s1.getValue().size());
                    if(sort == 0){
                        sort = s1.getKey().compareTo(s2.getKey());
                    }
                    return sort;
                }).forEach(x -> System.out.printf("The %s has %d DHARMA recruits in it.%n",x.getKey(),x.getValue().size()));
        }else{
            if(stations.containsKey(command)){
                System.out.printf("The %s station: %s%n",command,stationDetails.get(command));
               if(stations.get(command).size() > 0){
                   stations.get(command).entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey,Comparator.reverseOrder())).forEach(r -> System.out.printf("###%s - %d%n",r.getValue(),r.getKey()));
               }else{
                   System.out.println("No recruits.");
               }
            }else{
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }
    }
}