package exams;
import java.util.*;
import java.lang.*;
public class RubikCube {
    public static void main(String args[]) {
       Scanner scanner=new Scanner(System.in);
       int size=Integer.parseInt(scanner.nextLine());
       int [][][] cube=new int[size][size][size];
       String bombard="";
       int cubeSum=0;
       int emptyCells=(int)(Math.pow(size,3));
       while(!"Analyze".equals(bombard = scanner.nextLine())){
           int [] token=Arrays.stream(bombard.split(" ")).mapToInt(Integer::parseInt).toArray();
           int row=token[0];
           int col=token[1];
           int layer=token[2];
           int val=token[3];
           if(isValidCoordinate(row,col,layer,size) && val != 0){
               if(cube[row][col][layer] == 0){
                   cube[row][col][layer]=val;
                   cubeSum+=val;
                   emptyCells--;
                 }
           }
           
       }
       System.out.println(cubeSum);
       System.out.println(emptyCells);
    }
    public static boolean isValidCoordinate(int row,int col,int layer,int dimension){
        if(isValidIndex(row,dimension) && isValidIndex(col,dimension) && isValidIndex(layer,dimension)){
            return true;
        }
        return false;
    }
    public static boolean isValidIndex(int index,int dimension){
     if(index >= 0 && index < dimension){
         return true;
     }
         return false;
     
    }
    
}