package iteratorsandcomparators.petclinics;

import java.util.Iterator;
import java.util.Objects;

public class Pet implements Comparable<Pet>{
    String name;
    int age;
    String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return name + " " + age +" " + kind ;
    }

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Pet o) {
        return this.getName().compareTo(o.getName());
      /*  if(sort == 0){
            sort= Integer.compare(this.getAge(),o.getAge());
        }

        return (sort == 0)?this.getKind().compareTo(o.getKind()):sort;*/
    }
}
