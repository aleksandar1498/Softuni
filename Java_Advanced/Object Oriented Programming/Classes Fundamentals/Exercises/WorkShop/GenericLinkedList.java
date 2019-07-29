package oop.workshop;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class GenericLinkedList<T> {
    private class ListNode{
        ListNode next;
        ListNode previous;
        T val;
        public ListNode(T val){
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
    Class<T> c;
    public GenericLinkedList(Class<T> c) {
        this.c=c;
    }

    public void addFirst(T element){
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
    public T removeFirst(){
        checkSize();
        T val=this.head.val;
        this.head=this.head.next;
        if(this.head == null){
            this.tail = null;
        }else{
            this.head.previous=null;
        }

        this.size--;
        return val;
    }
    public void addLast(T element){

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
    public T removeLast(){
        checkSize();
        T val=this.tail.val;
        this.tail=this.tail.previous;
        if(this.tail == null){
            this.head = null;
        }else{
            this.tail.next=null;
        }

        this.size--;
        return val;
    }
    public T get(int index){
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
    public void forEach(Consumer<T> consumer){
        ListNode iterator=this.head;
        while(iterator != null){
            consumer.accept(iterator.val);
            iterator=iterator.next;
        }
    }
    public T[] toArray(){
        T [] array= (T[]) Array.newInstance(c,this.size);
        ListNode iterator=this.head;
        int index=0;
        while(iterator != null){
            array[index++] = iterator.val;
            iterator=iterator.next;
        }
        return array;
    }
}
