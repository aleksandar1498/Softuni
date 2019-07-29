package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> storage;

    public StudentRepository() {
        this.storage = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.storage;
    }

    public void add(String[] args) {
        String name = args[1];
        if (this.storage.containsKey(name)) {
            return;
        }
        int age = Integer.parseInt(args[2]);
        Double grade = Double.parseDouble(args[3]);
        Student student = new Student(name, age, grade);
        this.storage.put(name, student);

    }
}
