package oop.workshop;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class GenericStack<T> {
    private static final int STARTING_CAPACITY = 4;
    int size;
    int capacity;
    T[] data;
    Class<T> c;
    public GenericStack(Class<T> c) {
        this.data = (T[]) Array.newInstance(c,STARTING_CAPACITY);
        capacity = STARTING_CAPACITY;
    }

    public void push(T element) {
        if(this.size == this.capacity){
            resize();
        }
        this.data[size++]=element;
    }

    public T pop() {
        checkEmpty();
        T val=this.data[this.size-1];
        this.size--;
        return val;
    }

    public T peek() {
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
        T[] copy = (T[]) Array.newInstance(c,this.capacity);
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }
        data = copy;
    }
    public void forEach(Consumer<T> action){
        for (int i = 0; i < this.size; i++) {
            action.accept(this.data[i]);
        }
    }
}
