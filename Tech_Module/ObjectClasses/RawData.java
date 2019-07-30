package object_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
int n=Integer.parseInt(scanner.nextLine());
        ArrayList<Car> cars=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] data=scanner.nextLine().split(" ");
            RawData.Car c=new RawData.Car(data[0],Integer.valueOf(data[1]),Integer.valueOf(data[2]),Integer.valueOf(data[3]),data[4],Double.valueOf(data[5]),Integer.valueOf(data[6]),Double.valueOf(data[7]),Integer.valueOf(data[8]),Double.valueOf(data[9]),Integer.valueOf(data[10]),Double.valueOf(data[11]),Integer.valueOf(data[12]));
cars.add(c);
        }
        String command=scanner.nextLine();
        if(command.equals("fragile")){
            for (Car c: cars) {
                if(c.cargo.type.equals("fragile") && (c.tire1.pressure < 1 || c.tire2.pressure < 1 || c.tire3.pressure < 1 || c.tire4.pressure < 1)){
                    System.out.println(c.model);
                }
            }
        }else if(command.equals("flamable")){
            for (Car c: cars) {
                if(c.cargo.type.equals("flamable") && c.engine.speed > 250){
                    System.out.println(c.model);
                }
            }
        }
    }
    static class Car{
        String model="";
        Engine engine=null;
        Cargo cargo=null;
        Tire tire1=null;
        Tire tire2=null;
        Tire tire3=null;
        Tire tire4=null;
                 Car(String m,
                           int powerE,int speedE,
                           int weightC,String typeC,
                           double pressureT1,int ageT1,
                           double pressureT2,int ageT2,
                           double pressureT3,int ageT3,
                           double pressureT4,int ageT4){
            this.model=m;
            this.engine=new Engine(speedE,powerE);
            this.cargo=new Cargo(typeC,weightC);
            this.tire1=new Tire(ageT1,pressureT1);
            this.tire2=new Tire(ageT2,pressureT2);
            this.tire3=new Tire(ageT3,pressureT3);
            this.tire4=new Tire(ageT4,pressureT4);

                }
    }
    static class Engine{
        double power=0.0;
        int speed=0;
        Engine(int sp,double pr){
            this.power=pr;
            this.speed=sp;
        }
    }
    static class Cargo{
        String type="";
        int weight=0;
        Cargo(String t,int w){
            this.type=t;
            this.weight=w;
        }
    }
   static class Tire{
        int age=0;
        double pressure=0.0;
        Tire(int a,double p){
            this.age=a;
            this.pressure=p;
        }
    }
}
