package lists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Pattern numeric=Pattern.compile("\\d*");
        List<String> inputData=Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<Integer> numericPart=new ArrayList<>();
        for (int i=0;i<inputData.size();i++) {
            Matcher test=numeric.matcher(inputData.get(i));
            if(test.matches()){
            numericPart.add(Integer.valueOf(inputData.get(i)));
            inputData.remove(i);
            i--;
            }


        }
        List<Integer> takeList=new ArrayList<>();
        List<Integer> skipList=new ArrayList<>();
        for (int i = 0; i < numericPart.size(); i++) {
            if(i%2 ==0){
              takeList.add(numericPart.get(i));
            }else if(i%2 != 0){
                skipList.add(numericPart.get(i));
            }
        }
     List<String> result=new ArrayList<>();
        int initialPosition=0;
        for (int i = 0; i < takeList.size() ; i++) {
         String taken="";
if(takeList.get(i).equals(0)){
    initialPosition+=takeList.get(i)+skipList.get(i);
    continue;
}
          try {
              taken = String.valueOf(inputData.subList(initialPosition, (initialPosition + takeList.get(i))));
          }catch(Exception e) {
              taken = String.valueOf(inputData.subList(initialPosition, inputData.size()));

          }
result.add(taken.replaceAll("[\\[\\],]\\s",""));
            initialPosition+=takeList.get(i)+skipList.get(i);
        }
        String finalResult="";
        for (int i = 0; i < result.size(); i++) {
            char[] content=result.get(i).toCharArray();
            for (int j = 0; j < content.length; j++) {
                if(content[j] != '[' && content[j] != ']'){
                    finalResult=finalResult.concat(String.valueOf(content[j]));
                }
            }
        }
        System.out.println(finalResult.trim());

    }
}
