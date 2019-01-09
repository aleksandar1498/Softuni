import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPartition {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //String word="aleks a n d e";
        String word="aleksandar";
        String [] words=word.split("",3);
        System.out.println(String.join(" ",words));
/*List<String> result=new ArrayList<>();
        int numPart=3;
        if(word.length()%numPart == 0){
            int unit=word.length()/numPart;
            System.out.println(unit);
            for(int i=0;i<word.length();i+=unit){
                result.add(word.substring(i,i+unit));

            }
            System.out.println(result.toString().replaceAll("[\\[\\],]",""));
        }else{
            int unit=(int)Math.floor(word.length()/(double)numPart);
            int lastUnit=(int)word.length()-(unit*(numPart-1));
            for(int i=0;i<word.length();i+=unit){
                if(i == word.length()-lastUnit){
                    result.add(word.substring(i,i+lastUnit));
                    break;
                }
                result.add(word.substring(i,i+unit));

            }
            System.out.println(result.toString().replaceAll("[\\[\\],]",""));

            System.out.println(lastUnit+" "+unit);
        }*/
    }
}
