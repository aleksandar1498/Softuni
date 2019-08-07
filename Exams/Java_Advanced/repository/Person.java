package repository;

public class Person {
    String name;
    int age;
    String birthDate;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + '\n' +
                "Age: " + this.getAge() +'\n'+
                "Birthday: " + this.getBirthDate();
    }
}
