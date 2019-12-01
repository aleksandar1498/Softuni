package models;

public class Doctor {
    private String id;
    private String firstName;
    private int age;

    public Doctor(String id, String firstName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
