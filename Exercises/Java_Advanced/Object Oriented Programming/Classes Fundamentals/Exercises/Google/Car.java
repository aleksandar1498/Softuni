import java.util.*;
import java.text.DecimalFormat;
class Car{
    String model;
    double speed;
    public Car(String model,double speed){
        this.model=model;
        this.speed=speed;
    }
     @Override
    public String toString(){
        DecimalFormat df=new DecimalFormat("######.##");
        return String.format("%n%s %s%n",this.model,df.format(this.speed));
    }
}