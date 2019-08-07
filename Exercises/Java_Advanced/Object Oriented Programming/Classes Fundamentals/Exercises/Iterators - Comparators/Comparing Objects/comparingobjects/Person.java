package iteratorsandcomparators.comparingobjects;

public class Person implements Comparable<Person>{
    String name;
    int age;
    String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person o) {
        int sort=this.getName().compareTo(o.getName());
        if(sort == 0){
            sort=Integer.compare(this.getAge(),o.getAge());

        }
        if(sort == 0){
            sort=this.getTown().compareTo(o.getTown());
        }
        return sort;
    }
}
