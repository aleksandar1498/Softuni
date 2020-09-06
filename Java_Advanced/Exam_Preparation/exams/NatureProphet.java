package arena;
import java.util.*;
public class NatureProphet {
    public static void main(String args[]) {
       Scanner scanner=new Scanner(System.in);
       int [] dimensions=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       int [][] field=new int[dimensions[0]][dimensions[1]];
       List<Integer> flowersRow=new ArrayList<>();
       List<Integer> flowersCol=new ArrayList<>();
       String plant="";
       while(!"Bloom Bloom Plow".equals(plant = scanner.nextLine())){
           flowersRow.add(Integer.parseInt(plant.split(" ")[0]));
           flowersCol.add(Integer.parseInt(plant.split(" ")[1]));
       }
       for(int p=0;p<flowersRow.size();p++){
           bloomFlower(flowersRow.get(p),flowersCol.get(p),field);
       }
       for(int i=0;i<field.length;i++){
           for(int j=0;j<field.length;j++){
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
       }
    }
    public static void bloomFlower(int row,int col,int [][] field){
        for(int c=0;c<field[row].length;c++){
            field[row][c]++;
        }
        for(int r=0;r<field.length;r++){
            if(r != row)
                field[r][col]++;
        }
    }
}