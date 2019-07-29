package animal;

public abstract class Animal {
    protected String name;
    protected String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }




     String explainSelf() {
        return String.format("I am %s and my favourite food is %s",this.name,this.favouriteFood);
    }


}
