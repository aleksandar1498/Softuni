package oop.generics.genericbox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            GenericBox<String> box=new GenericBox<>(String.class,scanner.nextLine());
            System.out.println(box.toString());
        }
    }
}
