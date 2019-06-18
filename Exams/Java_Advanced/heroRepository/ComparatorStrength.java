package heroRepository;

import java.util.Comparator;

public class ComparatorStrength implements Comparator<Hero> {
    @Override
    public int compare(Hero o1, Hero o2) {
        return Integer.compare(o2.getItem().getStrength(),o1.getItem().getStrength());
    }
}
