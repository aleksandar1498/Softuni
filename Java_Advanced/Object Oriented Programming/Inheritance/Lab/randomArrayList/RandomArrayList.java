package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    public T getRandomElement(){
        int randomIndex = random.nextInt(super.size());
        T randomElement=super.remove(randomIndex);
        return randomElement;
    }
}
