import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       int n=Integer.parseInt(scanner.nextLine());
       for(int i=0;i<n;i++){
           String [] carData=scanner.nextLine().split(" ");
           Car c=null;
           if(carData.length == 3){
                c=new Car(carData[0],carData[1],Integer.parseInt(carData[2]));
           }else{
                c=new Car(carData[0]);
           }
          
           System.out.println(c.getInfo());
       }
       
    }
  
   
}