package oop.workshop;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomLinkedList {
    private class ListNode{
        ListNode next;
        ListNode previous;
        int val;
        public ListNode(int val){
            this.val=val;
        }

        @Override
        public String toString() {
            return this.val+"";

        }
    }
    ListNode head;
    ListNode tail;
    int size;
    public void addFirst(int element){
        ListNode node=new ListNode(element);
        if(this.size == 0){

           this.head=this.tail=node;

       }else{
           node.next=this.head;
           this.head.previous=node;
           this.head=node;
       }
        this.size++;
    }
    public int removeFirst(){
        checkSize();
        int val=this.head.val;
        this.head=this.head.next;
       if(this.head == null){
           this.tail = null;
       }else{
           this.head.previous=null;
       }

        this.size--;
        return val;
    }
    public void addLast(int element){

        ListNode node=new ListNode(element);
        if(this.size == 0){

            this.head=node;
            this.tail=node;
        }else{
            node.previous=this.tail;
            this.tail.next=this.tail;
            this.tail=node;
        }
        this.size++;
    }
    public int removeLast(){
        checkSize();
        int val=this.tail.val;
        this.tail=this.tail.previous;
        if(this.tail == null){
            this.head = null;
        }else{
            this.tail.next=null;
        }

        this.size--;
        return val;
    }
    public int get(int index){
        checkIndex(index);
        ListNode firstNode=this.head;
        for (int i = 0; i < index; i++) {
            firstNode=firstNode.next;
        }
        return firstNode.val;
    }
    public void checkIndex(int index){
        if(index < 0 || index >= size){
            String message=String.format("Index %d out of bounds for length %d",index,this.size);
            throw new ArrayIndexOutOfBoundsException(message);
        }
    }
    public void checkSize(){
        if(size == 0){
            throw new NoSuchElementException("The list is empty");
        }
    }
    public void forEach(Consumer<Integer> consumer){
        ListNode iterator=this.head;
        while(iterator != null){
            consumer.accept(iterator.val);
            iterator=iterator.next;
        }
    }
    public int[] toArray(){
        int [] array= new int[this.size];
        ListNode iterator=this.head;
        int index=0;
        while(iterator != null){
            array[index++] = iterator.val;
            iterator=iterator.next;
        }
        return array;
    }

}
