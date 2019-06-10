package iteratorsandcomparators.stackiterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StackIterator stackIterator=new StackIterator();
        String line="";
        while (!"END".equals(line = scanner.nextLine())){
            String [] token=line.replaceAll(",","").split(" ");
            switch (token[0]){
                case "Push":
                    Arrays.asList(token).stream().skip(1).mapToInt(Integer::parseInt).forEach(stackIterator::push);
                    break;
                case "Pop":
                    stackIterator.pop();
                    break;
            }
        }
        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
    }
}
