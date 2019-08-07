package militaryElit.enums;

public enum State {
    inProgress(true),
    Finished(false);
    boolean completed;

    State(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
