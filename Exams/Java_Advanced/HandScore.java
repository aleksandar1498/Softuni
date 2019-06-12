import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import java.util.regex.*;
import java.util.function.Predicate;
public class LetterExpression {
    public static List<String> values=new ArrayList<>(Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A"));
    public static void main(String args[]) {
      Scanner scanner=new Scanner(System.in);
      Pattern p=Pattern.compile("((?<val>([0-9]+|[JQKA]{1}))(?<suit>(C)|(S)|(H)|(D)))+");
      ArrayDeque<Combination> combinationStack=new ArrayDeque<>();
      String line=scanner.nextLine();
      long sum=0;
      long totSum=0;
      Matcher m=p.matcher(line);
      String sequence="inc";
      while(m.find()){
           
          int val=0;
          String suit=m.group("suit");
          if(Character.isDigit(m.group("val").charAt(0))){
             val = values.indexOf(m.group("val"))+2;
          }else{
             val = values.indexOf(m.group("val"))+3;  
          }
          if(combinationStack.size() == 0){
           
              combinationStack.add(new Combination(val,suit));
              sum+=val;
          }else{
           
              Combination previous=combinationStack.peek();
           
              if(combinationStack.size() == 1){
                  if(previous.getVal() < val){
                      sequence="inc";
                  }else if(previous.getVal() > val){
                      sequence="dec";
                  }
              }
                          if((previous.getVal() <= val && previous.getSuit().equals(suit) && sequence.equals("inc")) || (previous.getVal() >= val && previous.getSuit().equals(suit) && sequence.equals("dec"))){
                               //  System.out.println("1");
                                  combinationStack.push(new Combination(val,suit));
                                  sum+=val;
                            }else{
                                 // System.out.println("2 "+ combinationStack.size());
                                  totSum+=combinationStack.size()*sum;
                                  sum=val;
                                  combinationStack.clear();
                                  combinationStack.push(new Combination(val,suit));
                            }
              
          }  
      }
               
          
          
        
      
      totSum+=sum*combinationStack.size();
      System.out.println(totSum);
    }
    static class Combination{
        int val;
        String suit;
        public Combination(int val,String suit){
            this.val=val;
            this.suit=suit;
        }
        public int getVal(){
            return this.val;
        }
        public String getSuit(){
            return this.suit;
        }
        
    }
   
}