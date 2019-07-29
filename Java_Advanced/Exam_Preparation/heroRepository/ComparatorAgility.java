package heroRepository;

import java.util.Comparator;

public class ComparatorAgility implements Comparator<Hero> {
    @Override
    public int compare(Hero o1, Hero o2) {
        return Integer.compare(o2.getItem().getAgility(), o1.getItem().getAgility());
    }
}
