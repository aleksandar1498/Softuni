package froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    List<Integer> integers;

    public Lake() {
        integers = new ArrayList<>();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        int counter = 0;

        int lastEvenIndex=((integers.size()-1) % 2 == 0)?integers.size()-1:integers.size()-2;



        @Override
        public boolean hasNext() {

                return  counter < integers.size();

        }

        @Override
        public Integer next() {
            int val=integers.get(counter);
            if(counter == lastEvenIndex){
                counter=1;
            }else {
                counter+=2;
            }

            return val;

        }

    }
}
