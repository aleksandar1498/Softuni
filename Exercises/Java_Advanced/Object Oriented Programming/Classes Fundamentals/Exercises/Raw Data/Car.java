import java.util.*;

class Car{
    String model;
    Engine e;
    List<Tire> tires;
    Cargo cargo;
    public Car(){
        this.tires=new ArrayList<>();
    }
    public Car(String model,Engine e,Cargo c,Tire t1,Tire t2,Tire t3,Tire t4){
        this();
        this.model=model;
        this.e=e;
        this.cargo=c;
        this.tires.add(t1);
        this.tires.add(t2);
        this.tires.add(t3);
        this.tires.add(t4);
    }
    public boolean underPressureTires(){
        return (tires.stream().filter(t -> t.pressure < 1).count() > 0);
    }
}