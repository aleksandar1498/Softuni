package animal;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
     String explainSelf() {
        return String.format("%s%nDJAAF",super.explainSelf());
    }
}
