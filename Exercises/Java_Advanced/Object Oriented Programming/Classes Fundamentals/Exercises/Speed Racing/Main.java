package oop.speedracing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Set<Car> carSet=new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String [] carToken=scanner.nextLine().split(" ");
            String model=carToken[0];
            double fuelAmount=Double.parseDouble(carToken[1]);
            double fuelCostPerKM=Double.parseDouble(carToken[2]);
            carSet.add(new Car(model,fuelAmount,fuelCostPerKM));
        }
        String operation="";
        while(!"End".equals(operation = scanner.nextLine())){
            String [] operationToken=operation.split(" ");
            Iterator<Car> iter=carSet.iterator();
            while(iter.hasNext()){
                Car current=iter.next();
                if(current.getModel().equals(operationToken[1])){
                    current.move(Double.parseDouble(operationToken[2]));
                    break;
                }
            }
        }
        carSet.forEach(car -> System.out.println(car.toString()));

    }
}
