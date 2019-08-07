package genericbox;

public class GenericBox<T> {
    T val;
    Class<T> c;
    public GenericBox(Class<T> c,T val) {
        this.val = val;
        this.c=c;
    }

    @Override
    public String toString() {
        return c.getName()+": "+val;
    }
}
