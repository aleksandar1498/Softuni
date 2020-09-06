package arena;
import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import java.util.regex.*;
import java.util.function.Predicate;
public class LetterExpression {
    public static int maxCapacity=0;
    public static void main(String args[]) {
      Scanner scanner=new Scanner(System.in);
      String input=scanner.nextLine();
      ArrayDeque<Double> numbers=new ArrayDeque<>();
      String reg="(-)?[0-9]+";
      Pattern regex=Pattern.compile(reg);
      Matcher dM=regex.matcher(input);
      
      while(dM.find()){
          numbers.add(Double.parseDouble(dM.group()));
         // System.out.println(dM.group());
      }
        ArrayDeque<String> operators=new ArrayDeque<>(Arrays.asList(input.split(reg))
                .stream().filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));
        
        Predicate<String> isEven=s -> s.length()%2 == 0;
        double sum=numbers.pop();
        while(!numbers.isEmpty()){
           
            if(isEven.test(operators.pop())){
                sum+=numbers.pop();
            }else{
                sum-=numbers.pop();
                    
            }
           
        }
        DecimalFormat f = new DecimalFormat("##.#######");
        System.out.println(f.format(sum));
    }
   
}