import java.util.*;
import java.lang.*;
public class NaturalMessagingService {
    public static void main(String args[]) {
       Scanner scanner=new Scanner(System.in);
       StringBuilder builder=new StringBuilder();
       
       String message="";
       while(!"---NMS SEND---".equals(message = scanner.nextLine())){
           builder.append(message);
       }
      
       List<String> words=new ArrayList<>();
       String mes=builder.toString();
       System.out.println(mes);
       StringBuilder word=new StringBuilder();
       for(int i=0;i<mes.length();i++){
            word.append(mes.charAt(i)+"");
            if(i == mes.length()-1){
                
                    words.add(word.toString());
                    break;
                
            }
           if(mes.toUpperCase().charAt(i) > mes.toUpperCase().charAt(i+1)){
               words.add(word.toString());
               word.setLength(0);
           }
       }
       

      
      
       String delimeter=scanner.nextLine();
       
       System.out.println(String.join(delimeter,words.toString().replaceAll("[\\[\\],]","").split(" ")));
    }
    
}