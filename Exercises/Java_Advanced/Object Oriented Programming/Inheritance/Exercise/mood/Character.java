package mood;

public interface Character<T> {
    T hashPassword(String username);

    int getLevel();

    String getUsername();
}