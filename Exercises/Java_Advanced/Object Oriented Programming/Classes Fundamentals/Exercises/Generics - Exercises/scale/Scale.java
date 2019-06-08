package oop.generics.scale;

public class Scale<T extends Comparable<T>> {
    T left;
    T right;
    public Scale(T left,T right){
        this.left=left;
        this.right=right;
    }
    public T getHeavier(){
        if(left.compareTo(right) > 0){
            return this.left;
        }else if(left.compareTo(right) < 0){
            return this.right;
        }
        return null;
    }
}
