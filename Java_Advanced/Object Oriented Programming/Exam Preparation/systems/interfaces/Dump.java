package interfaces;

public interface Dump {
    Hardware restore(String string);
    void destroy(String string);
    void add(Hardware hardware);
    boolean contains(String string);
}
