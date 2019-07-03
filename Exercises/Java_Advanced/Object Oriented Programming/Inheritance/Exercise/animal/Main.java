package animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!"Beast!".equals(command = scanner.nextLine())) {
            String[] animalToken = scanner.nextLine().split("\\s+");
            Animal animal=null;
            String name=animalToken[0];
            int age = Integer.parseInt(animalToken[1]);
            String gender=animalToken[2];
            switch (command) {
                case "Dog":
                    animal=new Dog(name,age,gender);
                    break;
                case "Cat":
                    animal=new Cat(name,age,gender);
                    break;
                case "Kitten":
                    animal=new Kitten(name,age,gender);
                    break;
                case "Tomcat":
                    animal=new Tomcat(name,age,gender);
                    break;
                case "Frog":
                    animal=new Frog(name,age,gender);
                    break;

            }
            if(animal != null){
                System.out.println(animal.toString());
            }
        }
    }
}
