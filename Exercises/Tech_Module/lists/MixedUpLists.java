package lists;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> firstList= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultingList=new ArrayList<>();
        int lowLimit=0,topLimit=0;
        while(firstList.size() > 0 && secondList.size() > 0){
            resultingList.add(firstList.get(0));
            firstList.remove(0);
            resultingList.add(secondList.get(secondList.size()-1));
            secondList.remove(secondList.size()-1);
        }
        if(firstList.size() > 0){
            lowLimit=Math.min(firstList.get(0),firstList.get(1));
            topLimit=Math.max(firstList.get(0),firstList.get(1));
        }else{
            lowLimit=Math.min(secondList.get(0),secondList.get(1));
            topLimit=Math.max(secondList.get(0),secondList.get(1));
        }
        int finalLowLimit = lowLimit;
        int finalTopLimit = topLimit;
        resultingList= resultingList.stream().filter(integer -> (integer > finalLowLimit && integer < finalTopLimit)).collect(Collectors.toList());
        resultingList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) return 1;
                if(o1 < o2) return -1;
                return 0;
            }
        });
        System.out.println(String.join(" ",resultingList.toString().replaceAll("[\\[\\],]","")));
     }
}
