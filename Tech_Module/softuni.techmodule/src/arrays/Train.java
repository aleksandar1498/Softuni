package arrays;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] peopleInWagon;
        int totPeople=0;
        int n=Integer.parseInt(scanner.nextLine());
        peopleInWagon=new int[n];
        for (int i = 0; i < n; i++) {
            peopleInWagon[i]=Integer.parseInt(scanner.nextLine());
            totPeople+=peopleInWagon[i];
        }
        for (int people:peopleInWagon) {
            System.out.print(people+" ");
        }
        System.out.println();
        System.out.println(totPeople);
    }
}
