package needForSpeed;

import needForSpeed.cars.Car;
import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;
import needForSpeed.races.CasualRace;
import needForSpeed.races.Race;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner scanner=new Scanner(System.in);
     String command="";
        CarManager carManager = new CarManager();

        while (!"Cops Are Here".equals(command = scanner.nextLine())){
         String [] commandToken = command.split("\\s+");
         switch (commandToken[0]){
             case "register":
                 carManager.register(
                         Integer.parseInt(commandToken[1]),
                         commandToken[2],
                         commandToken[3],
                         commandToken[4],
                         Integer.parseInt(commandToken[5]),
                         Integer.parseInt(commandToken[6]),
                         Integer.parseInt(commandToken[7]),
                         Integer.parseInt(commandToken[8]),
                         Integer.parseInt(commandToken[9]));
                 break;
             case "check":
                 System.out.println(carManager.check(Integer.parseInt(commandToken[1])));
                 break;
             case "open":
                 carManager.open(
                         Integer.parseInt(commandToken[1]),
                         commandToken[2],
                         Integer.parseInt(commandToken[3]),
                         commandToken[4],
                         Integer.parseInt(commandToken[5])
                 );
                 break;
             case "participate":
                 carManager.participate(
                         Integer.parseInt(commandToken[1]),
                         Integer.parseInt(commandToken[2]));
                 break;
             case "start":
                 System.out.println(carManager.start(Integer.parseInt(commandToken[1])));
                 break;
             case "park":
                 carManager.park(Integer.parseInt(commandToken[1]));
                 break;
             case "unpark":
                 carManager.unpark(Integer.parseInt(commandToken[1]));
                 break;
             case "tune":
                 carManager.tune(
                         Integer.parseInt(commandToken[1]),
                         commandToken[2]
                 );
                 break;

         }
     }
    }
}
