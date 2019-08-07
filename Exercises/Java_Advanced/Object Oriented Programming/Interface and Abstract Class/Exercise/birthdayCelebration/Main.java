package birthdayCelebration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Birthable> birthables=new ArrayList<>();
        String command="";
        while(!"End".equals(command = scanner.nextLine())){
            String [] commandToken=command.split(" ");
            Birthable birthable=null;
            switch (commandToken[0]){
                case "Citizen":
                    birthable = new Citizen(commandToken[1],Integer.parseInt(commandToken[2]),commandToken[3],commandToken[4]);
                    break;
                case "Pet":
                    birthable = new Pet(commandToken[1],commandToken[2]);
                    break;
            }
            if(birthable != null){
                birthables.add(birthable);
            }
        }
        String year=scanner.nextLine();
            birthables.stream().filter(x -> x.getBirthDate().endsWith(year)).forEach(b -> System.out.println(b.getBirthDate()));


    }

}
