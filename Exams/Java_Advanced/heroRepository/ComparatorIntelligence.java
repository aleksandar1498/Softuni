package heroRepository;

import java.util.Comparator;

public class ComparatorIntelligence implements Comparator<Hero> {

    @Override
    public int compare(Hero o1, Hero o2) {
        return Integer.compare(o2.getItem().getIntelligence(), o1.getItem().getIntelligence());
    }
}
