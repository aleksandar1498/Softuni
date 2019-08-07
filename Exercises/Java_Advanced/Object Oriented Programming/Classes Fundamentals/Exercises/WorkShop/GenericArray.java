package oop.workshop;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class GenericArray<T> {
    private static final int INITIAL_CAPACITY=4;
    private T [] data;
    // size of data
    private int size;
    // size of the array
    private int capacity;
    Class<T> c;
    public GenericArray(Class<T> c) {
        this.c=c;
        this.data = (T[]) Array.newInstance(c,INITIAL_CAPACITY);
        this.capacity=INITIAL_CAPACITY;
    }
    private void resize(){
        this.capacity*=2;
        T [] copy=(T[]) Array.newInstance(c,this.capacity);
        for(int i=0;i<data.length;i++){
            copy[i]=data[i];
        }
        data=copy;
    }
    private void shrink(){
        this.capacity/=2;
        T [] copy=(T[]) Array.newInstance(c,this.capacity);
        for(int i=0;i<this.size;i++){
            copy[i]=data[i];
        }
        data=copy;
    }
    public void add(T element){
        if(this.size == this.capacity ){
            this.resize();
        }
        this.data[size++]=element;
    }
    public void add(int index,T element){
        checkIndex(index);
        if(this.size == this.capacity ){
            this.resize();
        }
        shiftRight(index);
        this.data[index]=element;
        this.size++;
    }
    public T get(int index){
        checkIndex(index);
        return this.data[index];
    }
    public T remove(int index){
        checkIndex(index);
        T val = this.data[index];
        this.data[index] = null;
        shiftLeft(index);
        this.size--;
        if(this.size <= this.capacity/4){
            shrink();
        }
        return val;
    }
    public boolean contains(T element){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element){
                return true;
            }
        }
        return false;
    }
    public void shiftLeft(int index){
        for(int i=index;i < this.size-1;i++){
            this.data[i]=this.data[i+1];
        }
    }
    public void shiftRight(int index){
        for(int i=size;i > index;i--){
            this.data[i]=this.data[i-1];
        }
    }
    public void checkIndex(int index){
        if(index < 0 || index >= size){
            String message=String.format("Index %d out of bounds for length %d",index,this.size);
            throw new ArrayIndexOutOfBoundsException(message);
        }
    }

    public void forEach(Consumer<T> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
