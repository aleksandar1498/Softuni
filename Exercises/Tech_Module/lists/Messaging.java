package lists;

import java.util.Arrays;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] listOfNumbers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String message=scanner.nextLine();
        String response="";
        for (int i = 0; i < listOfNumbers.length; i++) {
            int digitAccordingToIndex=0;
            for(char c: String.valueOf(listOfNumbers[i]).toCharArray()){
                digitAccordingToIndex+= Integer.parseInt(c+"");
            }
            if(digitAccordingToIndex > message.length()-1){
                digitAccordingToIndex=digitAccordingToIndex-(int)((digitAccordingToIndex / message.length())*message.length());
            }
            response+=message.charAt(digitAccordingToIndex);
           message= message.replaceFirst(message.charAt(digitAccordingToIndex)+"","");
        }
        System.out.println(response);
    }
}
