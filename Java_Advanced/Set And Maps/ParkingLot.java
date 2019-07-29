import java.util.*;
import java.util.regex.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Pattern p=Pattern.compile("(?<operation>IN|OUT), (?<number>[A-Z]{2}[0-9]{4}[A-Z]{2})");
        Set<String> cars=new  HashSet<>();
        String input="";
        while(!"END".equals(input = scanner.nextLine())){
           
            Matcher m=p.matcher(input);
            if(m.find()){
                String operation=m.group("operation");
                String number=m.group("number");
                switch(operation){
                    case "IN":
                        cars.add(number);
                        break;
                    case "OUT":
                        cars.remove(number);
                        break;
                }
            }
        }
        if(cars.size() == 0){
            System.out.println("Parking Lot is Empty");
            return;
        }
        cars.forEach(System.out::println);
        
    }
}