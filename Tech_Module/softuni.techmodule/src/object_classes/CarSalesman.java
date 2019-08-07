package object_classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Engine> engines = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        int engineQuantity = Integer.parseInt(scanner.nextLine());
        for (int engine = 0; engine < engineQuantity; engine++) {
            String[] engineInfo = scanner.nextLine().split(" ");
            if (engineInfo.length == 4) {
                engines.add(new Engine(engineInfo[0], Integer.valueOf(engineInfo[1]), Integer.valueOf(engineInfo[2]), engineInfo[3]));
            } else if (engineInfo.length == 3) {
                try {
                    engines.add(new Engine(engineInfo[0], Integer.valueOf(engineInfo[1]), Integer.valueOf(engineInfo[2]), "n/a"));

                } catch (NumberFormatException e) {
                    engines.add(new Engine(engineInfo[0], Integer.valueOf(engineInfo[1]), -1, engineInfo[2]));
                }

            } else {
                engines.add(new Engine(engineInfo[0], Integer.valueOf(engineInfo[1]), -1, "n/a"));

            }
        }
        int numCars = Integer.parseInt(scanner.nextLine());
        for (int car = 0; car < numCars; car++) {
            String[] carInfo = scanner.nextLine().split(" ");
            Engine engineToAdd = null;
            if(engines.stream().anyMatch(engine -> engine.model.equals(carInfo[1]))){
               engineToAdd=engines.stream().filter(new Predicate<Engine>() {
                   @Override
                   public boolean test(Engine engine) {
                       if(engine.model.equals(carInfo[1])){
                           return  true;
                       }
                       return false;
                   }
               }).findFirst().get();
            }else{
                continue;
            }
            if (carInfo.length == 4) {
cars.add(new Car(carInfo[0],engineToAdd,Integer.valueOf(carInfo[2]),carInfo[3]));
            } else if (carInfo.length == 3) {
                try {
                    cars.add(new Car(carInfo[0], engineToAdd, Integer.valueOf(carInfo[2]),"n/a"));
                }catch (NumberFormatException e) {
                    cars.add(new Car(carInfo[0], engineToAdd, -1, carInfo[2]));
                }
            } else {
                cars.add(new Car(carInfo[0],engineToAdd,-1,"n/a"));

            }
        }
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(    cars.get(i).toString());

        }
    }

    static class Car {
        String model = "";
        Engine e = null;
        int weight = 0;
        String color = "";

        Car(String m, Engine e, int w, String c) {
            this.model = m;
            this.e = e;
            this.weight = w;
            this.color = c;
        }

        Car(String m, Engine e, int w) {
            this.model = m;
            this.e = e;
            this.weight = w;
        }

        Car(String m, Engine e, String c) {
            this.model = m;
            this.e = e;
            this.color = c;
        }

        Car(String m, Engine e) {
            this.model = m;
            this.e = e;
        }


       public String toString() {
            StringBuilder builder=new StringBuilder();
           if(this.weight == -1){
                if(this.e.displacement == -1) {
                    builder.append(this.model).append("\n").append(this.e.model).append(":\n").append("Power: ").append(this.e.power).append("\n").append("Displacement: n/a\n").append("Efficiency: ").append(this.e.efficiency).append("\n").append("Weight: n/a\n").append("Color: ").append(this.color).append("\n");
                }else{
                    builder.append(this.model).append("\n").append(this.e.model).append(":\n").append("Power: ").append(this.e.power).append("\n").append("Displacement: ").append(this.e.displacement).append("\n").append("Efficiency: ").append(this.e.efficiency).append("\n").append("Weight: n/a\n").append("Color: ").append(this.color).append("\n");
                }
            }else{
                if(this.e.displacement == -1) {
                    builder.append(this.model).append("\n").append(this.e.model).append(":\n").append("Power: ").append(this.e.power).append("\n").append("Displacement: n/a\n").append("Efficiency: ").append(this.e.efficiency).append("\n").append("Weight: ").append(this.weight).append("\n").append("Color: ").append(this.color).append("\n");
                }else{
                    builder.append(this.model).append("\n").append(this.e.model).append(":\n").append("Power: ").append(this.e.power).append("\n").append("Displacement: ").append(this.e.displacement).append("\n").append("Efficiency: ").append(this.e.efficiency).append("\n").append("Weight: ").append(this.weight).append("\n").append("Color: ").append(this.color).append("\n");
                }
            }
            return builder.toString();

        }
    }

    static class Engine {
        String model = "";
        int power = 0;
        int displacement = 0;
        String efficiency = "";

        Engine(String mod, int pow, int disp, String eff) {
            this.model = mod;
            this.power = pow;
            this.displacement = disp;
            this.efficiency = eff;
        }

        Engine(String mod, int pow, int disp) {
            this.model = mod;
            this.power = pow;
            this.displacement = disp;
        }

        Engine(String mod, int pow, String eff) {
            this.model = mod;
            this.power = pow;
            this.efficiency = eff;
        }

        Engine(String mod, int pow) {
            this.model = mod;
            this.power = pow;
        }
    }
}
