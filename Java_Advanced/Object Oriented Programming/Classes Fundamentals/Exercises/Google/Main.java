import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Person> people=new LinkedHashMap<>();
        String line="";
        while(!"End".equals(line = scanner.nextLine())){
            String [] token=line.split(" ");
            String name=token[0];
            String operation=token[1];
            people.putIfAbsent(name,new Person());
                switch(operation){
                case "company":
                    String companyName=token[2];
                    String department=token[3];
                    double salary=Double.parseDouble(token[4]);
                    people.get(name).setCompany(new Company(companyName,department,salary));
                    break;
                case "car":
                    String model=token[2];
                    double speed=Double.parseDouble(token[3]);
                    people.get(name).setCar(new Car(model,speed));
                    break;
                case "children":
                    String childName=token[2];
                    String childBirth=token[3];
                    people.get(name).addChildren(new Person(childName,childBirth));
                    break;
                case "parents":
                    String parentName=token[2];
                    String parentBirth=token[3];
                    people.get(name).addParent(new Person(parentName,parentBirth));
                    break;
                case "pokemon":
                    String pokeName=token[2];
                    String type=token[3];
                    people.get(name).addPokemon(new Pokemon(pokeName,type));
                    break;
                }
            
            
          
        }
        String searched=scanner.nextLine();
        Person p=people.get(searched);
       System.out.println(searched);
       p.printDetails();
           
        

    }
}