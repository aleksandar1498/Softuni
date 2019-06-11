package iteratorsandcomparators.stackiterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.function.Consumer;

public class StackIterator implements Iterable<Integer>{
    ArrayDeque<Integer> stack;

    public StackIterator() {
        this.stack = new ArrayDeque<>();
    }
    public void push(int element){
        this.stack.push(element);

    }
    public int pop(){
        if(this.stack.isEmpty()){
            System.out.println("No elements");
            return -1;
        }
        return this.stack.pop();
    }



    @Override
    public Iterator<Integer> iterator() {
        return new CustomStackIterator();
    }

    private final class CustomStackIterator implements Iterator<Integer>{
        int counter=0;
        @Override
        public boolean hasNext() {
            if(counter < stack.size()){
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            int val=stack.pop();
            stack.addLast(val);
            counter++;
            return val;
        }
    }
}
