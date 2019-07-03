package animal;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private String getGender() {
        return gender;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.isBlank() || name.matches("\\s+")){
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Invalid input");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if(gender.isBlank() || gender.isEmpty() || gender.matches("\\s+")){
            throw new IllegalArgumentException("Invalid input");

        }
        this.gender = gender;
    }

    protected String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder(this.getClass().getSimpleName());
        builder.append(System.lineSeparator());
        builder.append(String.format("%s %d %s",this.getName(),getAge(),getGender()));
        builder.append(System.lineSeparator());
        builder.append(this.produceSound());
        return builder.toString();
    }
}
