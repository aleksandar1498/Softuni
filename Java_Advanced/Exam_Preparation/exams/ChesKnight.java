package arena;
import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       String [][] chessTable=new String[8][8];
       List<String> takenPieces=new ArrayList<>();
       for(int i=0;i<chessTable.length;i++){
           chessTable[i]=scanner.nextLine().split("\\|");
       }
       int [] knightPositions=Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
       int outOfBoardMoves=0;
       int invalidSteps=0;
       int knightR=knightPositions[0];
       int knightC=knightPositions[0];

       String input="";
       while(!"END".equals(input = scanner.nextLine())){
           int [] coordinates=Arrays.stream(input.replaceAll("( -> )","").split("")).mapToInt(Integer::parseInt).toArray();
           int r1=coordinates[0];
           int c1=coordinates[1];
           int r2=coordinates[2];
           int c2=coordinates[3];
           if(r1 != knightR || c1 != knightC){
              
               invalidSteps++;
               continue;
           }
           if(isInLimit(r2,c2,chessTable)){
               if(isValid(r1,c1,r2,c2)){
                   if(!chessTable[r2][c2].equals(" ")){
                       takenPieces.add(chessTable[r2][c2]);
                   }
                   knightR=r2;
                   knightC=c2;
               }else{
                   invalidSteps++;
               }
           }else{
               outOfBoardMoves++;
           }

          // System.out.println(x1+" "+y1+" "+x2+" "+y2+" "+(isValid(x1,y1,x2,y2))+" ");
       }
       System.out.printf("Pieces take: %s%n",takenPieces.toString().replaceAll("[\\[\\]]",""));
       System.out.printf("Invalid moves: %d%n",invalidSteps);
       System.out.printf("Board out moves: %d%n",outOfBoardMoves);
       // System.out.println(knightR+" "+knightC);
     //  table(chessTable);
      
       
    }
    private static void table(String [][] table){
        for(int i=0;i<table.length;i++){
           for(int j=0;j<table.length;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
       }
    }
    private static boolean isInLimit(int r,int c,String [][] table){
     return (r >= 0 && c < table[r].length);
         
    }
    private static boolean isValid(int r1,int c1,int r2,int c2){
        if(Math.abs(r1-r2) == 2 && Math.abs(c1-c2) == 1){
            return true;
        }else if(Math.abs(r1-r2) == 1 && Math.abs(c1-c2) == 2){
            return true;
        }
        return false;
    }
}