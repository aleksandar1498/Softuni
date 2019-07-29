import java.text.DecimalFormat;
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       int numEngines=Integer.parseInt(scanner.nextLine());
      Map<String,Engine> engines=new LinkedHashMap<>();
       for(int i=0;i<numEngines;i++){
           String [] engineToken=scanner.nextLine().split(" ");
           String model=engineToken[0];
           double power=Double.parseDouble(engineToken[1]);
           if(engineToken.length == 4){
               double displacement=Double.parseDouble(engineToken[2]);
               String efficiency=engineToken[3];
               engines.put(model,new Engine(model,power,displacement,efficiency));
           }else if(engineToken.length == 3){
               if(Character.isDigit(engineToken[2].charAt(0))){
                    double displacement=Double.parseDouble(engineToken[2]);
                    engines.put(model,new Engine(model,power,displacement));
               }else{
                   String efficiency=engineToken[2];
                   engines.put(model,new Engine(model,power,efficiency));
               }
               
           }else{
               engines.put(model,new Engine(model,power));
           }
       }
      /* for(Map.Entry<String,Engine> engine:engines.entrySet()){
           System.out.println(engine.toString());
       }*/
       List<Car> cars=new ArrayList<>();
       int numCars=Integer.parseInt(scanner.nextLine()); 
       for(int i=0;i<numCars;i++){
           String [] carToken=scanner.nextLine().split(" ");
           String model=carToken[0];
           Engine e=engines.get(carToken[1]);
           
           if(e == null){
               continue;
           }
           if(carToken.length == 4){
               double weight=Double.parseDouble(carToken[2]);
               String color=carToken[3];
               cars.add(new Car(model,e,weight,color));
           }else if(carToken.length == 3){
               if(Character.isDigit(carToken[2].charAt(0))){
                    double weight=Double.parseDouble(carToken[2]);
                    cars.add(new Car(model,e,weight));
               }else{
                    String color=carToken[2];
                    cars.add(new Car(model,e,color));
               }
           }else{
               cars.add(new Car(model,e));
           }
       }
       cars.forEach(car -> System.out.print(car.toString()));
       
    }
}