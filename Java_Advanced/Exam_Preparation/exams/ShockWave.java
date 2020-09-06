package arena;
import java.util.*;
import java.util.stream.*;
public class Shockwave {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int [] dimension=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [][] room=new int[dimension[0]][dimension[1]];
        String input="";
        while(!"Here We Go".equals(input = scanner.nextLine())){
            int [] coordinates=Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int r=coordinates[0];r<=coordinates[2];r++){
                for(int c=coordinates[1];c<=coordinates[3];c++){
                    room[r][c]++;
                }
            }
        }
        for(int r=0;r<room.length;r++){
            for(int c=0;c<room[r].length;c++){
                System.out.print(room[r][c]+" ");
            }
            System.out.println();
        }
        
        
    }
}