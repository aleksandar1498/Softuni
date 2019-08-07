package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        List<Person> people=new ArrayList<>();
        List<Product> products=new ArrayList<>();
        Arrays.stream(bufferedReader.readLine().split(";")).forEach(p -> {
            Person person=new Person(p.split("=")[0],Integer.parseInt(p.split("=")[1]));
            if(!people.contains(person)){
                people.add(person);
            }
        });
        Arrays.stream(bufferedReader.readLine().split(";")).forEach(p -> {
            Product product=new Product(p.split("=")[0],Integer.parseInt(p.split("=")[1]));
            if(!products.contains(product)){
                products.add(product);
            }
        });
        String command="";
        while(!"END".equals(command = bufferedReader.readLine())){
            String personName=command.split("\\s+")[0];
            String productName=command.split("\\s+")[1];
            Person person=people.stream().filter(x -> x.getName().equals(personName)).findFirst().orElse(null);
            Product product=products.stream().filter(x -> x.getName().equals(productName)).findFirst().orElse(null);
            if(person != null && product != null){
                people.get(people.indexOf(person)).buyProduct(product);
            }
        }
        for (Person person : people) {
            System.out.println(person);
        }

    }
}
