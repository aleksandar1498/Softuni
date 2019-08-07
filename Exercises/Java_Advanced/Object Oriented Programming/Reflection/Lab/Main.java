package annotations;

import annotations.codingTracker.Author;
import annotations.codingTracker.Tracker;
import annotations.subject.Subject;
import annotations.subject.TestClass;

public class Main {
    @Author(name = "Vesi")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Main.class);
    }
}
