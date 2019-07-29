package customExceptions;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) throws InvalidPersonNameException {
        this.setName(name);
        this.email = email;
    }

    public void setName(String name) throws InvalidPersonNameException {
        if(!name.matches("[A-Za-z ]+")){
            throw new InvalidPersonNameException("Name can contain only letters");

        }
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            Student student = new Student("a21@s","Alex@gmail");
        } catch (InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }
}
