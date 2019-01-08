package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> listOne= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo=Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listResult=new ArrayList<>();
        for (int i = 0; i < listOne.size()+listTwo.size(); i++) {
            try{
                listResult.add(listOne.get(i));
            }catch (Exception e){
                for (int j = i; j < listTwo.size(); j++) {
                    listResult.add(listTwo.get(j));

                }
                break;
            }
            try{
                listResult.add(listTwo.get(i));
            }catch (Exception e){
                for (int j = i+1; j < listOne.size(); j++) {
                    listResult.add(listOne.get(j));

                }
                break;
            }
        }
        System.out.println(String.join(" ",listResult.toString()));
    }
}
