package object_classes;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyRoster {
    public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
int numEm=Integer.parseInt(scanner.nextLine());
double highestAverage=Integer.MIN_VALUE;
Department maxAv=null;
ArrayList<Department> departments=new ArrayList<>();
        for (int i = 0; i < numEm; i++) {
            String [] data =scanner.nextLine().split(" ");
            Employee e;
            if(data.length == 6){
                e=new Employee(data[0],Double.valueOf(data[1]), data[2], data[3], data[4],Integer.valueOf(data[5]));
            }else if(data.length == 5){
                try {
                    e = new Employee(data[0], Double.valueOf(data[1]), data[2], data[3], Integer.valueOf(data[4]));
                }catch (NumberFormatException er){
                    e=new Employee(data[0],Double.valueOf(data[1]), data[2], data[3], data[4]);

                }
            }else{
                e=new Employee(data[0],Double.valueOf(data[1]), data[2], data[3]);

            }
            Department d=new Department(data[3]);
            if(departments.size() == 0){
                departments.add(d);
                departments.get(departments.size()-1).employees.add(e);
            }else{
                if(checkData(departments,d.name)){
                    departments.get(getIndex(departments,d.name)).employees.add(e);
                }else{
                    departments.add(d);
                    departments.get(departments.size()-1).employees.add(e);
                }
            }
        }
        for (int i = 0; i < departments.size() ; i++) {
            if(departments.get(i).getTotAverage() > highestAverage){
                highestAverage=departments.get(i).getTotAverage();
                maxAv=departments.get(i);
            }
        }
        System.out.printf("Highest Average Salary : %s %d\n",maxAv.name,maxAv.employees.size());

        for (int i = 0; i < maxAv.employees.size()-1; i++) {
            for (int j = i+1; j < maxAv.employees.size(); j++) {
                if(maxAv.employees.get(i).salary < maxAv.employees.get(j).salary){
                    Employee temp=maxAv.employees.get(i);
                    maxAv.employees.set(i,maxAv.employees.get(j));
                    maxAv.employees.set(j,temp);
                }
            }

        }
        for (int i = 0; i < maxAv.employees.size() ; i++) {
            maxAv.employees.get(i).showEmployee();

        }


    }
    public static boolean checkData(ArrayList<Department> departmentArrayList,String name){
        for (int i = 0; i < departmentArrayList.size(); i++) {
            if(departmentArrayList.get(i).name.equals(name)){

                return true;
            }
        }
        return false;
    }
    public  static int getIndex(ArrayList<Department> departmentArrayList,String name){
        for (int i = 0; i < departmentArrayList.size(); i++) {
            if(departmentArrayList.get(i).name.equals(name)){

                return i;
            }
        }
        return 0;
    }

    public static class Employee{
        String name;
        double salary;
        String position;
        String department;
        String email="";
        int age=0;
        public Employee(String name,double salary,String position,String department,String email,int age){
            this.name=name;
            this.salary=salary;
            this.position=position;
            this.department=department;
            this.email=email;
            this.age=age;
        }
        public Employee(String name,double salary,String position,String department,int age){
            this.name=name;
            this.salary=salary;
            this.position=position;
            this.department=department;
            this.age=age;
        }
        public Employee(String name,double salary,String position,String department,String email){
            this.name=name;
            this.salary=salary;
            this.position=position;
            this.department=department;
            this.email=email;
        }
        public Employee(String name,double salary,String position,String department){
            this.name=name;
            this.salary=salary;
            this.position=position;
            this.department=department;

        }
        public void showEmployee(){
            System.out.printf("%s %.2f %s  %d\n",name,salary,(email.equals("")? "n/a":email ),(age == 0) ? -1:age);
        }
    }
    public static class Department{
ArrayList<Employee> employees;
public int averageDepartment=0;
String name="";
Department(String name){
    this.name=name;
    employees=new ArrayList<>();
}
double getTotAverage(){
    double sum=0.0;
    for (int i = 0; i < employees.size(); i++) {
        sum+=employees.get(i).salary;
    }
    return sum/employees.size();
}
    }

}
