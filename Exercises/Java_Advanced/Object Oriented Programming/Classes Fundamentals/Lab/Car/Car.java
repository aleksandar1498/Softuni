public class Car{
    private String make;
    private String model;
    private int horsePower;
    public void setMake(String make){
        this.make=make;
    }
    public String getMake(){
        return this.make;
    }
    
    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public int getHorsePower(){
        return this.horsePower;
    }
    public void setHorsePower(int horsePower){
        this.horsePower=horsePower;
    }
    public String getInfo(){
        return String.format("The car is: %s %s - %d HP.",this.getMake(),this.getModel(),this.getHorsePower());
    }
    
}