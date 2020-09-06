package arena;
import java.util.Arrays;
import java.util.Scanner;

public class HelenAbduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        String[][] castle = new String[numberOfRows][];
        int parisRow = -1;
        int parisCol = -1;
        for (int i = 0; i < numberOfRows; i++) {
            castle[i] = scanner.nextLine().split("");
            if (Arrays.asList(castle[i]).contains("P")) {
                parisCol = Arrays.asList(castle[i]).indexOf("P");
                parisRow = i;
            }
        }
         castle[parisRow][parisCol]="-";
        boolean parisAlive = true;
        while (parisEnergy > 0) {
            String[] token = scanner.nextLine().split(" ");
            String direction = token[0];
            int rowSpawn = Integer.parseInt(token[1]);
            int colSpawn = Integer.parseInt(token[2]);
            if (inLimit(rowSpawn, colSpawn, castle)) {
                castle[rowSpawn][colSpawn] = "S";
            }
            switch (direction) {
                case "up":
                    if (inLimit(parisRow - 1, parisCol, castle)) {
                        parisRow--;
                    }
                    break;
                case "left":
                    if (inLimit(parisRow, parisCol - 1, castle)) {
                        parisCol--;
                    }
                    break;
                case "down":
                    if (inLimit(parisRow + 1, parisCol, castle)) {
                        parisRow++;
                    }
                    break;
                case "right":
                    if (inLimit(parisRow, parisCol + 1, castle)) {
                        parisCol++;
                    }
                    break;

            }
            parisEnergy--;
            if (castle[parisRow][parisCol].equals("S")) {
                if (parisEnergy - 2 > 0) {
                    parisEnergy-=2;
                    castle[parisRow][parisCol] = "-";
                } else {
                    castle[parisRow][parisCol] = "X";
                    System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                    printCastle(castle);
                    return;
                }
            } else if (castle[parisRow][parisCol].equals("H")) {
                castle[parisRow][parisCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                printCastle(castle);
                return;
            }

        }
        castle[parisRow][parisCol] = "X";
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        printCastle(castle);
    }

    public static boolean inLimit(int row, int col, String[][] castle) {
        return (row >= 0 && row < castle.length) && (col < castle[row].length && col >= 0);
    }

    public static void printCastle(String[][] castle) {
       
        for (int i = 0; i < castle.length; i++) {
            for (int j = 0; j < castle[i].length; j++) {
                System.out.print(castle[i][j]);
            }
            System.out.println();
        }
    }
}
