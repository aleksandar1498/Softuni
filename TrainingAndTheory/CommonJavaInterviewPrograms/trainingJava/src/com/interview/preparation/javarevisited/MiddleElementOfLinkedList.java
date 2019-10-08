package com.interview.preparation.javarevisited;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;

public class MiddleElementOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
      /*  Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> secondIterator = list.iterator();
        boolean secondIteration = false;
        int middle = -1;
        while(iterator.hasNext()){
            if(secondIteration){
                middle = secondIterator.next();

            }
            iterator.next();
            secondIteration = !secondIteration;
        }
        if(list.size()%2 == 1){
            middle = secondIterator.next();
        }*/
        System.out.println(findKthElement(list,3));

    }
    public static int findKthElement(LinkedList<Integer> linkedList,int k){
        Iterator<Integer> iterator = linkedList.iterator();
        Iterator<Integer> secondIterator = linkedList.iterator();
        boolean secondIteration = false;
        int middle = -1;
        while(iterator.hasNext()){
            if(secondIteration){
                for (int i = 0; i < k; i++) {
                    middle = secondIterator.next();
                }


            }
            iterator.next();
            secondIteration = !secondIteration;
        }

        return middle;
    }
}
