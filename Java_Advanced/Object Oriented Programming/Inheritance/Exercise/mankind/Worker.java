package mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if(weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");

        }
        this.workHoursPerDay = workHoursPerDay;
    }
    private double salaryPerHour(){
        return this.weekSalary/7/workHoursPerDay;
    }
    @Override
    protected void setLastName(String lastName) {
        super.setLastName(lastName);
        if(lastName.length() <= 3){
            throw new IllegalArgumentException("Expected length more then 3 symbols!Argument: lastName");

        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("Week Salary : ").append(this.weekSalary);
        builder.append(System.lineSeparator());
        builder.append("Hours per day : ").append(this.workHoursPerDay);
        builder.append(System.lineSeparator());
        builder.append("Salary per hour : ").append(this.salaryPerHour());
        return builder.toString();
    }
}
