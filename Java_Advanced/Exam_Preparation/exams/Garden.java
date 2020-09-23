package exams;
import java.util.*;
public class Garden {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int numCarrots=0;
        int numPotatoes=0;
        int numLettuce=0;
        int harmedVeggies=0;
        String [][] field=new String[n][];
        for(int i=0;i<n;i++){
            field[i]=scanner.nextLine().split(" ");
            
        }
        String line="";
        while(!"End of Harvest".equals(line = scanner.nextLine())){
            String [] token=line.split(" ");
            String operation=token[0];
            int row=Integer.parseInt(token[1]);
            int col=Integer.parseInt(token[2]);
            if(inBounds(row,col,field)){
                switch(operation){
                    case "Harvest":
                        switch(field[row][col]){
                            case "L":
                                numLettuce++;
                                field[row][col]=" ";
                                break;
                            case "P":
                                numPotatoes++;
                                field[row][col]=" ";
                                break;
                            case "C":
                                numCarrots++;
                                field[row][col]=" ";
                                break;
                        }
                         
                        break;
                    case "Mole":
                        String direction=token[3];
                        switch(direction){
                            case "up":
                                while(row >= 0){
                                    if(inBounds(row,col,field) && field[row][col].matches("[PCL]+") ){
                                        field[row][col]=" ";
                                        harmedVeggies++;
                                        
                                    }
                                    row-=2;
                                }
                                break;
                            case "right":
                                while(col < field[row].length){
                                    if(inBounds(row,col,field) && field[row][col].matches("[PCL]+") ){
                                        field[row][col]=" ";
                                        harmedVeggies++;
                                        
                                    }
                                    col+=2;
                                }
                                break;
                            case "down":
                                while(row < field.length){
                                    if(inBounds(row,col,field) && field[row][col].matches("[PCL]+") ){
                                        field[row][col]=" ";
                                        harmedVeggies++;
                                        
                                    }
                                    row+=2;
                                }
                                break;
                            case "left":
                                 while(col >= 0){
                                    if(inBounds(row,col,field) && field[row][col].matches("[PCL]+") ){
                                        field[row][col]=" ";
                                        harmedVeggies++;
                                        
                                    }
                                    col-=2;
                                }
                                break;
                            
                        }
                        break;
                        
                }
               
            }
            
        }
        printField(field);
        System.out.printf("Carrots: %d%n",numCarrots);
        System.out.printf("Potatoes: %d%n",numPotatoes);
        System.out.printf("Lettuce: %d%n",numLettuce);
        System.out.printf("Harmed vegetables: %d%n",harmedVeggies);
    }
    public static void printField(String [][] field){
        
        for(int i=0;i<field.length;i++){
            StringBuilder builder=new StringBuilder();
            for(int j=0;j<field[i].length;j++){
                builder.append(field[i][j]+" ");
            }
            System.out.println(builder.toString().replaceAll("\\s+$",""));
        }
    }
    public static boolean inBounds(int row,int col,String [][] field){
        return ((row >= 0 && row < field.length) && (col >= 0 && col < field[row].length));
    }
}