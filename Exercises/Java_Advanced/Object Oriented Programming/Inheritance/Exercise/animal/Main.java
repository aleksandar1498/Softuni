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
            try {
                switch (command) {
                    case "Dog":
                        animal=new Dog(name,age,gender);
                        break;
                    case "Cat":
                        animal=new Cat(name,age,gender);
                        break;
                    case "Kitten":
                        animal=new Kitten(name,age);
                        break;
                    case "Tomcat":
                        animal=new Tomcat(name,age);
                        break;
                    case "Frog":
                        animal=new Frog(name,age,gender);
                        break;

                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            if(animal != null){
                System.out.println(animal.toString());
            }
        }
    }
}
