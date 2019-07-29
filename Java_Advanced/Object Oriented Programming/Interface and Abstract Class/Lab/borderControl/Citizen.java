package borderControl;

public class Citizen implements Identifiable {
    private String name;
    private int age;
    private String id;


    public Citizen(String name,int age, String id ) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
