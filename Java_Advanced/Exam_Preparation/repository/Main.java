package repository;

public class Main {
    public static void main(String[] args) {

        //Initialize the repository
        Repository repository = new Repository();
        Repository repository2 = new Repository();
        //Initialize Person
        Person person = new Person("Pesho", 14, "13-07-2004");

        //Add two entities
        repository.add(person);

        //Initialize second Person object
        Person secondPerson = new Person("Gosho", 42, "21-09-1976");
        repository2.add(secondPerson);

        System.out.println(repository.get(0).toString());
        System.out.println(repository2.get(0).toString());
    }

}
