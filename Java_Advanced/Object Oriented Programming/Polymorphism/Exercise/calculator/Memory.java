package calculator;

import java.util.ArrayDeque;

public class Memory implements Savable, Clearable {
    private ArrayDeque<Integer> results;

    public Memory() {
        this.results = new ArrayDeque<>();
    }

    @Override
    public Integer removeLast() {
        return this.results.pop();
    }

    @Override
    public void saveIn(int value) {
        this.results.push(value);
    }
}
