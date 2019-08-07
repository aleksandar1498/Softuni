import java.util.*;
import java.util.regex.*;
public class ProductShop {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Map<String,LinkedHashMap<String,Double>> shops=new TreeMap<>();
       String action="";
       while(!"Revision".equals(action = scanner.nextLine())){
            String [] shopToken=action.split(", ");
            String name=shopToken[0];
            String product=shopToken[1];
            Double price=Double.parseDouble(shopToken[2]);
            if(!shops.containsKey(name)){
                shops.put(name,new LinkedHashMap<>());
            }
               
            shops.get(name).put(product,price);
       }
       shops.entrySet().stream().forEach(shop -> {
           System.out.println(shop.getKey()+"->");
           shop.getValue().entrySet().stream().forEach(x -> System.out.printf("Product: %s, Price: %.1f%n",x.getKey(),x.getValue()));
       });
     
    }
}