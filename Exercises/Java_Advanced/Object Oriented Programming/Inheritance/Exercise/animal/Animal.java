package animal;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }


    private void setGender(String gender) {
        this.gender = gender;
    }

    protected abstract String produceSound() ;


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
