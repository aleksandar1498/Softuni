import java.text.DecimalFormat;
class Car{
    String model;
    Engine engine;
    double weight;
    String color;
    public Car(String model,Engine engine){
        this.model=model;
        this.engine=engine;
        this.weight=-1;
        this.color="n/a";
    }
    public Car(String model,Engine engine,double weight,String color){
        this(model,engine);
        this.weight=weight;
        this.color=color;
    }
    
    public Car(String model,Engine engine,double weight){
        this(model,engine);
        this.weight=weight;
    }
    
    public Car(String model,Engine engine,String color){
        this(model,engine);
        this.color=color;
    }
    public String getModel(){
        return this.model;
    }
    public Engine getEngine(){
        return this.engine;
    }
    public double getWeight(){
        return this.weight;
    }
    public String getColor(){
        return this.color;
    }
    @Override
    public String toString(){
        DecimalFormat df=new DecimalFormat("######.##");
        String weight=(this.getWeight() == -1)?"n/a": df.format(this.getWeight());
        return String.format("%s:%n%s%nWeight: %s%nColor: %s%n",this.getModel(),this.getEngine().toString(),weight,this.getColor());
    }
    
}