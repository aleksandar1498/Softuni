package oop.workshop;

public class Main {
    public static void main(String[] args) {
      GenericArray<String> genericArray=new GenericArray<>(String.class);
        genericArray.add("Alex");
        genericArray.add("Prova");
        genericArray.forEach(System.out::println);


    }
}
