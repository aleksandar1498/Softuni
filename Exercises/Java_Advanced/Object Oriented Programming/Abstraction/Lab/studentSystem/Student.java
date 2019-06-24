package studentSystem;

import java.util.Objects;

public class Student{
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public String getTypeStudent(){

        if (this.getGrade() >= 5.00)
        {
            return  "Excellent student.";
        }
        else if (this.getGrade() < 5.00 && this.getGrade() >= 3.50)
        {
            return  "Average student.";
        }
        else
        {
            return  "Very nice person.";
        }
    }
    @Override
    public String toString() {
       return String.format("%s is %d years old. %s",this.getName(),this.getAge(),this.getTypeStudent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.getName().equals(((Student) o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade);
    }
}
