package vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carToken = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carToken[1]), Double.parseDouble(carToken[2]));
        String[] truckToken = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckToken[1]), Double.parseDouble(truckToken[2]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandToken = scanner.nextLine().split("\\s+");
            String typeCommand = commandToken[0];
            String typeVehicle = commandToken[1];
            switch (typeCommand) {
                case "Drive":
                    double km = Double.parseDouble(commandToken[2]);
                    if (typeVehicle.equals("Car")) {
                        car.drive(km);
                    } else if (typeVehicle.equals("Truck")) {
                        truck.drive(km);
                    }
                    break;
                case "Refuel":
                    double fuel = Double.parseDouble(commandToken[2]);
                    if (typeVehicle.equals("Car")) {
                        car.refuel(fuel);
                    } else if (typeVehicle.equals("Truck")) {
                        truck.refuel(fuel);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
