package oop.companyroster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;
    private String name;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department(String name){
        this.name=name;
        employees=new ArrayList<>();
    }
    public double getSalaryAverage(){
        double sum=this.employees.stream().mapToDouble(em -> em.getSalary()).sum();

        return sum/this.employees.size();
    }
    public String getName(){
        return this.name;
    }
    public void addEmployee(Employee e){
        this.employees.add(e);
    }

}
