package mood;

public abstract class CharacterImpl<T> implements Character {
    private String username;
    private T hashedPassword;
    private int level;

    public CharacterImpl(String username, int level) {
        this.username = username;
        this.level = level;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
    @Override
    public String getUsername() {
        return username;
    }
    public T getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(T hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {

        return String.format("\"%s\" | \"%s\" -> %s", this.getUsername(), this.getHashedPassword(), this.getClass().getSimpleName());
    }
}
