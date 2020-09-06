package arena;
import java.util.*;
import java.util.stream.*;
public class Snake {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int [] values=Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        String [][] sky=new String[values.length][];
        for(int i=0;i<sky.length;i++){
            sky[i]=Integer.toBinaryString(0x10000 | values[i]).substring(1).split("");
        }
        
        for(int col=0;col<sky[0].length;col++){
            for(int row = sky.length-2;row >= 0;row--){
                if(sky[row][col].equals("1")){
                    int nextRow=row;
                   
                    List<String> subs=new ArrayList<>();
                    for(int start=row+1;start < sky.length;start++){
                        subs.add(sky[start][col]);
                    }
                  //  System.out.println("SubList " +subs);
                    if(subs.contains("1")){
                        //the next row is the current row + distance of the next 1 
                        nextRow=row+subs.indexOf("1");
                    }else{
                        nextRow=sky.length-1;
                    }
                     //System.out.println(row+" "+col+ " NExt "+nextRow);
                    if(nextRow != row){
                        sky[row][col]="0";
                        sky[nextRow][col]="1";
                    }
                }
            }
        }
        List<Integer> result=new ArrayList<>();
         for(int i=0;i<sky.length;i++){
          result.add(Integer.parseInt(String.join(" ",sky[i]).replaceAll(" ",""),2));
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]",""));
    }
}