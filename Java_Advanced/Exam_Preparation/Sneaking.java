package lineardatastructure.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sneaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] map = new String[n][n * 2];
        int samRow = -1;
        int samCol = -1;
        // Read the map
        for (int i = 0; i < n; i++) {
            map[i] = scanner.nextLine().split("");
            if (Arrays.asList(map[i]).contains("S")) {
                samRow = i;
                samCol = Arrays.asList(map[i]).indexOf("S");
            }
        }
        String[] commands = scanner.nextLine().split("");
        for (String command : commands) {
            //Enemies move
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    //b goes right d goes left
                    if (map[i][j].equals("b")) {
                        if (j == map[i].length - 1) {
                            map[i][j] = "d";
                        } else {
                            map[i][j] = ".";
                            map[i][++j] = "b";
                        }
                    } else if (map[i][j].equals("d")) {
                        if (j == 0) {
                            map[i][j] = "b";
                        } else {
                            map[i][j] = ".";
                            map[i][j - 1] = "d";
                        }
                    }
                }
            }
            //Check if there is an enemy looking at sam
            for (int i = 0; i < map.length; i++) {
                List<String> row = Arrays.asList(map[i]);
                if (row.contains("S") && (row.contains("d") || row.contains("b"))) {
                    if (row.contains("d") && row.indexOf("d") > row.indexOf("S")) {
                        map[i][row.indexOf("S")] = "X";
                        System.out.printf("Sam died at %d, %d%n", i, row.indexOf("X"));
                        printMatrix(map);
                        return;
                    } else if (row.contains("b") && row.indexOf("b") < row.indexOf("S")) {
                        map[i][row.indexOf("S")] = "X";
                        System.out.printf("Sam died at %d, %d%n", i, row.indexOf("X"));
                        printMatrix(map);
                        return;
                    }
                }
            }
            //Move sam
            switch (command) {
                case "U":
                    map[samRow][samCol] = ".";
                    map[--samRow][samCol] = "S";
                    break;
                case "D":
                    map[samRow][samCol] = ".";
                    map[++samRow][samCol] = "S";
                    break;
                case "L":
                    map[samRow][samCol] = ".";
                    map[samRow][--samCol] = "S";
                    break;
                case "R":
                    map[samRow][samCol] = ".";
                    map[samRow][++samCol] = "S";
                    break;
                default:
                    break;
            }
            //Check if Nik is on the same row of Sam
            if (Arrays.asList(map[samRow]).contains("N")) {
                map[samRow][Arrays.asList(map[samRow]).indexOf("N")] = "X";
                System.out.println("Nikoladze killed!");
                printMatrix(map);
                return;
            }
        }
    }

    static void printMatrix(String[][] mat) {
        for (String[] strings : mat) {
            System.out.println(String.join("", strings));
        }
    }
}
