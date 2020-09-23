package exams;
import java.util.*;
import java.util.stream.*;
public class CubeArtillery {
    public static int maxCapacity=0;
    public static void main(String args[]) {
       Scanner scanner=new Scanner(System.in);
       maxCapacity=Integer.parseInt(scanner.nextLine());
       ArrayDeque<String> bunkersStack=new ArrayDeque<>();
       ArrayDeque<Integer> weaponQueue=new ArrayDeque<>();
      String input="";
      int freeCapacity=maxCapacity;
       while(!"Bunker Revision".equals(input = scanner.nextLine())){
           String [] token=input.split(" ");
           for(int i=0;i<token.length;i++){
               if(Character.isDigit(token[i].charAt(0))){
                   int wCapacity=Integer.parseInt(token[i]);
                   boolean added=false;
                   while(bunkersStack.size() > 1){
                       if(freeCapacity >= wCapacity){
                         freeCapacity-=wCapacity;
                         weaponQueue.offer(wCapacity);
                         added=true;
                         break;
                       }
                       if(weaponQueue.size() == 0){
                           System.out.printf("%s -> Empty%n",bunkersStack.pop());
                       }else{
                           System.out.printf("%s -> %s%n",bunkersStack.pop(),weaponQueue.toString().replaceAll("[\\[\\]]",""));
                       }
                     
                       weaponQueue.clear();
                       freeCapacity=maxCapacity;
                       
                   }
                   if(!added && bunkersStack.size() == 1){
                       if(freeCapacity >= wCapacity){
                          weaponQueue.offer(wCapacity);
                          freeCapacity-=wCapacity;
                       }else{
                           
                           if(wCapacity <= maxCapacity){
                               while(freeCapacity < wCapacity){
                                   freeCapacity+=weaponQueue.poll();
                               }
                               weaponQueue.offer(wCapacity);
                               freeCapacity-=wCapacity;
                           }
                       }
                   }
                   
                  
                   
               }else{
                    
                    bunkersStack.addLast(token[i]);
                    
               }
           }
       }
    }
   
}