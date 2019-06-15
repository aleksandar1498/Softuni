package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JediGalaxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] size=Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[size[0]][size[1]];
        int totStars=0;
        populateMatrix(map);
        String g="";
        while (!"Let the Force be with you".equals(g = scanner.nextLine())){
            String e=scanner.nextLine();

            int [] goodCoordinates= Arrays.stream(g.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int [] evilCoordinates= Arrays.stream(e.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            while(evilCoordinates[0] >= 0 && evilCoordinates[1] >= 0){
                if(inLimit(evilCoordinates[0],evilCoordinates[1],map)){
                    map[evilCoordinates[0]][evilCoordinates[1]]=0;
                }
                evilCoordinates[0]--;
                evilCoordinates[1]--;
            }
            while(goodCoordinates[0] >= 0 && goodCoordinates[1] < map[0].length){
                if(inLimit(goodCoordinates[0],goodCoordinates[1],map)){
                    totStars+=map[goodCoordinates[0]][goodCoordinates[1]];
                }
                goodCoordinates[0]--;
                goodCoordinates[1]++;
            }
        }
        System.out.println(totStars);


    }

    public static boolean inLimit(int r, int c, int[][] mat) {
        return (r >= 0 && r < mat.length && c >= 0 && c < mat[r].length);
    }

    public static void populateMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = i * mat.length + j;
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }


}
