package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseInputToIntegerArray(scanner.nextLine());
        int row = dimensions[0];
        int col = dimensions[1];
        Galaxy galaxy= new Galaxy(row,col);
        String command ="";
        long collectedStars = 0;
        while (!"Let the Force be with you".equals(command = scanner.nextLine())) {
            int[] ivoCoordinates = parseInputToIntegerArray(command);
            int[] evilCoordinates = parseInputToIntegerArray(scanner.nextLine());
            int evilX = evilCoordinates[0];
            int evilY = evilCoordinates[1];
            galaxy.destroy(evilX, evilY);
            int ivoX = ivoCoordinates[0];
            int ivoY = ivoCoordinates[1];
            collectedStars += galaxy.collectStars(galaxy, ivoX, ivoY);

        }

        System.out.println(collectedStars);


    }

    private static int[] parseInputToIntegerArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

    }






}
