import java.util.*;
import java.util.regex.*;
public class Voina {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
       
      LinkedHashSet<Integer> player1=new  LinkedHashSet<>();
       LinkedHashSet<Integer> player2=new  LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(card -> player1.add(card));
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(card -> player2.add(card));
     
        int rounds=0;
       
      while(rounds < 50){
            
            if(player1.size() == 0){
                System.out.println("Second player win!");
                return;
            }
             if(player2.size() == 0){
                System.out.println("First player win!");
              return;
            }
            int cardPlayer1=player1.iterator().next();
            int cardPlayer2=player2.iterator().next();
            player1.remove(cardPlayer1);
            player2.remove(cardPlayer2);
            if(cardPlayer1 > cardPlayer2){
              
                player1.add(cardPlayer2);
            }else if(cardPlayer2 > cardPlayer1){
                 player2.add(cardPlayer1);
                
            }
           
            rounds++;
        }
        System.out.println("Draw!");
     
    }
}