package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> integerList= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int size=(int)Math.floor(integerList.size()/2.0);
        for (int i = 0; i < size; i++) {
            integerList.set(i,integerList.get(integerList.size()-1)+integerList.get(i));
            integerList.remove(integerList.size()-1);
        }
        System.out.printf("Result "+String.join(" ",integerList.toString()));
    }
}
