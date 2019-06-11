package strategypattern;

import java.util.Comparator;

public class FirstCustomComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int sort=Integer.compare(o1.getName().length(),o2.getName().length());
        if(sort == 0){
            sort=Character.compare(o1.getName().toUpperCase().charAt(0),o2.getName().toUpperCase().charAt(0));
        }
        return sort;
    }
}
