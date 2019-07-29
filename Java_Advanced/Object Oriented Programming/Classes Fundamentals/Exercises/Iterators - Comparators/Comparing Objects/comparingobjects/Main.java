package iteratorsandcomparators.comparingobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input="";
        List<Person> people=new ArrayList<>();
        while (!"END".equals(input = scanner.nextLine())){
            String [] token=input.split(" ");
            people.add(new Person(token[0],Integer.parseInt(token[1]),token[2]));
        }
        int index=Integer.parseInt(scanner.nextLine());
        int notEqual=(int)people.stream().filter(p -> p.compareTo(people.get(index-1)) != 0).count();
        int equalPeople=(int)people.stream().filter(p -> p.compareTo(people.get(index-1)) == 0).count();
        if(equalPeople == 1){
            System.out.println("No matches");
            return;
        }
    System.out.println(equalPeople+" "+notEqual+" "+(equalPeople+notEqual));
}
}
