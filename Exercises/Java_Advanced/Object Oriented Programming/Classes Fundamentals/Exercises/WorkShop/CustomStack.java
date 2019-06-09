package oop.workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int STARTING_CAPACITY = 4;
    int size;
    int capacity;
    int[] data;

    public CustomStack() {
        this.data = new int[STARTING_CAPACITY];
        capacity = STARTING_CAPACITY;
    }

    public void push(int element) {
        if(this.size == this.capacity){
            resize();
        }
        this.data[size++]=element;
    }

    public int pop() {
        checkEmpty();
        int val=this.data[this.size-1];
        this.size--;
        return val;
    }

    public int peek() {
        checkEmpty();
        return this.data[this.size-1];
    }
    public void checkEmpty(){
        if(this.size == 0){
            throw new NoSuchElementException("CustomStack is empty");
        }
    }
    public void resize() {
        this.capacity *= 2;
        int[] copy = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }
        data = copy;
    }
    public void forEach(Consumer<Integer> action){
        for (int i = 0; i < this.size; i++) {
            action.accept(this.data[i]);
        }
    }
}
