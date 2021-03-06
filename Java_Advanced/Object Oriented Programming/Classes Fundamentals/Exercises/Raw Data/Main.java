import java.util.*;
import java.util.function.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<Car> cars=new ArrayList<>();
        for(int i=0;i<n;i++){
            String [] carData=scanner.nextLine().split(" ");
            String model=carData[0];
            Engine e=new Engine(Double.parseDouble(carData[1]),Double.parseDouble(carData[2]));
            Cargo c=new Cargo(Double.parseDouble(carData[3]),carData[4]);
            Tire t1=new Tire(Double.parseDouble(carData[5]),Integer.parseInt(carData[6]));
            Tire t2=new Tire(Double.parseDouble(carData[7]),Integer.parseInt(carData[8]));
            Tire t3=new Tire(Double.parseDouble(carData[9]),Integer.parseInt(carData[10]));
            Tire t4=new Tire(Double.parseDouble(carData[11]),Integer.parseInt(carData[12]));
            cars.add(new Car(model,e,c,t1,t2,t3,t4));
            
        }
        String command = scanner.nextLine();
        Predicate<Car> predicate=checkType(command);
        Function<Car,Boolean> fun=c -> predicate.test(c);
        cars.stream().filter(c -> fun.apply(c)).forEach(car -> System.out.println(car.model));
    
    }
    public static Predicate<Car> checkType(String type)
        {
            if(type.equals("flamable")){
                return c -> (c.cargo.type.equals("flamable") && c.e.power > 250);
            }else if(type.equals("fragile")){
               return  c -> (c.cargo.type.equals("fragile") && c.underPressureTires());
            }
            return null;
        }
    
}