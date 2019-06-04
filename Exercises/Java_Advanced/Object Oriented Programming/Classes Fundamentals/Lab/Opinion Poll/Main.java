import java.util.*;
import java.text.*;
import java.util.function.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       int n=Integer.parseInt(scanner.nextLine());
       List<Person> people=new ArrayList<>();
       for(int i=0;i<n;i++){
           String [] personDetails=scanner.nextLine().split(" ");
           String name=personDetails[0];
           int age=Integer.parseInt(personDetails[1]);
           people.add(new Person(name,age));
       }
     
       people.stream().sorted((p1,p2) -> p1.getName().compareTo(p2.getName())).filter((p) -> p.getAge() > 30).forEach(person -> {
           System.out.println(person.getName()+" - "+person.getAge());
       });
    }
}