package studentSystem;


import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    StudentRepository studentRepository;

    public StudentSystem() {
        studentRepository = new StudentRepository();
    }

    public void ParseCommand(String[] args) {
        if (args[0].equals("Create")) {
            studentRepository.add(args);
        } else if (args[0].equals("Show")) {
            if (this.studentRepository.getRepo().containsKey(args[1]))
                System.out.println(this.studentRepository.getRepo().get(args[1]));
        }
    }
}

