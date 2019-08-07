package lineardatastructure.exam;

import java.util.*;
import java.util.stream.Collectors;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> socks=new ArrayDeque<>();
        ArrayDeque<Integer> leftSocks=new ArrayDeque<>(){{
            addAll(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        }};
        ArrayDeque<Integer> rightSocks=new ArrayDeque<Integer>(){{
            addAll(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        }};
        while(leftSocks.size() > 0 && rightSocks.size() > 0) {
            int lastLeftSock = leftSocks.removeLast();
            int firstRightSock = rightSocks.removeFirst();
            if (lastLeftSock > firstRightSock) {
                socks.add(lastLeftSock + firstRightSock);

            } else if (lastLeftSock == firstRightSock) {
                leftSocks.addLast(lastLeftSock + 1);
            } else if (firstRightSock > lastLeftSock) {
                rightSocks.addFirst(firstRightSock);
            }
        }
        System.out.println(socks.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println(socks.toString().replaceAll("[\\[\\],]",""));


    }
}
