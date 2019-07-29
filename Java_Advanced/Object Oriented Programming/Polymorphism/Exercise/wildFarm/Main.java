package wildFarm;


import wildFarm.abstracts.Animal;
import wildFarm.abstracts.Food;
import wildFarm.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command="";
        List<Animal> animals= new ArrayList<>();
        List<Food> foods=new ArrayList<>();
        while(!"End".equals(command = scanner.nextLine())){
            String [] commandToken=command.split("\\s+");
            String [] foodToken=scanner.nextLine().split("\\s+");
            Animal animal=null;
            Food food=null;
            switch (commandToken[0]){
                case "Cat":
                    animal=new Cat(commandToken[1],"Cat",Double.parseDouble(commandToken[2]),commandToken[3],commandToken[4]);
                    break;
                case "Tiger":
                    animal=new Tiger(commandToken[1],"Tiger",Double.parseDouble(commandToken[2]),commandToken[3]);

                    break;
                case "Zebra":
                    animal=new Zebra(commandToken[1],"Zebra",Double.parseDouble(commandToken[2]),commandToken[3]);

                    break;
                case "Mouse":
                    animal=new Mouse(commandToken[1],"Mouse",Double.parseDouble(commandToken[2]),commandToken[3]);

                    break;
            }
            switch (foodToken[0]){
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodToken[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodToken[1]));
                    break;
            }
            if(animal != null && food != null){
                animals.add(animal);
                foods.add(food);

            }

        }
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).makeSound());
            try {
                animals.get(i).eat(foods.get(i));
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

    }
}
