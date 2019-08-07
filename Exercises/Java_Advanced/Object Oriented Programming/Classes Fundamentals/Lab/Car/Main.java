import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       int n=Integer.parseInt(scanner.nextLine());
       for(int i=0;i<n;i++){
           String [] carData=scanner.nextLine().split(" ");
           Car c=new Car();
           c.setMake(carData[0]);
           c.setModel(carData[1]);
           c.setHorsePower(Integer.parseInt(carData[2]));
           System.out.println(c.getInfo());
       }
       
    }
  
   
}