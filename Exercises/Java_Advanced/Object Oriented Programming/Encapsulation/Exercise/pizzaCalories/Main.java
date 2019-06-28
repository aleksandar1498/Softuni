package pizzaCalories;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String [] pizzaToken=scanner.nextLine().split("\\s+");

        Pizza pizza=new Pizza(pizzaToken[1],Integer.parseInt(pizzaToken[2]));

        String [] doughToken=scanner.nextLine().split("\\s+");
        Dough dough=new Dough(doughToken[1],doughToken[2],Double.parseDouble(doughToken[3]));
        assert pizza != null;
        pizza.setDough(dough);
        String command="";
        while(!"END".equals(command = scanner.nextLine())){
            String [] commandToken=command.split("\\s+");
            Topping topping=new Topping(commandToken[1],Double.parseDouble(commandToken[2]));
            if(topping != null){
                pizza.addTopping(topping);
            }

        }
        System.out.println(pizza);


    }


}
