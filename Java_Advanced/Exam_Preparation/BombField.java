package exams;

import java.util.Scanner;

public class BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] field = new char[fieldSize][fieldSize];
        int xStart = 0;
        int yStart = 0;
        int bombCount = 0;
        for (int i = 0; i < fieldSize; i++) {

            char[] row = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 's') {
                    yStart = i;
                    xStart = j;
                } else if (row[j] == 'B') {
                    bombCount++;
                }
                field[i][j] = row[j];
            }
        }
        for (String command : commands) {
            switch (command) {
                case "up":
                    if (yStart - 1 >= 0) {
                        yStart--;
                    }
                    break;
                case "right":
                    if (xStart + 1 <= fieldSize - 1) {
                        xStart++;
                    }
                    break;
                case "left":
                    if (xStart - 1 >= 0) {
                        xStart--;
                    }
                    break;
                case "down":
                    if (yStart + 1 <= fieldSize - 1) {
                        yStart++;
                    }
                    break;
            }
            if (field[yStart][xStart] == 'B') {
                System.out.println("You found a bomb!");
                field[yStart][xStart]='+';
                bombCount--;
                if (bombCount == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            }else if(field[yStart][xStart] == 'e'){
                System.out.printf("END! %d bombs left on the field\n",bombCount);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCount,yStart,xStart);
        /*for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
        }*/
    }
}
