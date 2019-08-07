package listyiterator;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line="";
        ListyIterator listy=null;
        while(!"END".equals(line=scanner.nextLine())){
            
            String [] token=line.split(" ");
            switch(token[0]){
                case "Create":
                   
                    listy=new ListyIterator(Arrays.copyOfRange(token, 1, token.length));
                  
                    break;
                case "Move":
                    System.out.println(listy.move());
                    break;
                case "Print":
                    listy.print();
                    break;
                case "HasNext":
                    System.out.println(listy.hasNext());
                    break;
            }
        }
        
     
        
    }
}