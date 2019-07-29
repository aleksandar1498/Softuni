package mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(System.in);
            String [] studentToken=scanner.nextLine().split("\\s+");
            Student student=new Student(studentToken[0],studentToken[1],studentToken[2]);
            System.out.println(student);
            String [] workerToken=scanner.nextLine().split("\\s+");
            Worker worker=new Worker(workerToken[0],workerToken[1],Double.parseDouble(workerToken[2]),Double.parseDouble(workerToken[3]));
            System.out.println(worker);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }
}
