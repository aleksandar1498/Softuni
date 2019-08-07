import java.text.DecimalFormat;
class Engine{
    private String model;
    private double power;
    private double displacement;
    private String efficiency;
    
    public Engine(String model,double power){
        this.model=model;
        this.power=power;
        this.displacement=-1;
        this.efficiency="n/a";
    }
    
    public Engine(String model,double power,double displacement,String efficiency){
        this(model,power);
        this.displacement=displacement;
        this.efficiency=efficiency;
    }
    public Engine(String model,double power,double displacement){
        this(model,power);
        this.displacement=displacement;
    }
    public Engine(String model,double power,String efficiency){
        this(model,power);
        this.efficiency=efficiency;
    }
    public String getModel(){
        return this.model;
    }
    public String getEfficiency(){
        return this.efficiency;
    }
    public double getPower(){
        return this.power;
    }
    public double getDisplacement(){
        return this.displacement;
    }
    @Override
    public String toString(){
        DecimalFormat df=new DecimalFormat("######.##");
        String disp=(this.getDisplacement() == -1)?"n/a": df.format(this.getDisplacement());
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s",this.getModel(),df.format(this.getPower()) ,disp,this.getEfficiency());
    }
}