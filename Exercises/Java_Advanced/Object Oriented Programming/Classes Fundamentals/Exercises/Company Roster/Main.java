package oop.companyroster;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] emplyeeDetails = scanner.nextLine().split(" ");
            String name = emplyeeDetails[0];
            double salary = Double.parseDouble(emplyeeDetails[1]);
            String position = emplyeeDetails[2];
            String dep = emplyeeDetails[3];
            Employee employee = null;
            if (emplyeeDetails.length == 6) {
                String email = emplyeeDetails[4];
                int age = Integer.parseInt(emplyeeDetails[5]);
                employee = new Employee(name, salary, position, dep, email, age);
            } else if (emplyeeDetails.length == 5) {
                if (Character.isDigit(emplyeeDetails[4].charAt(0))) {
                    int age = Integer.parseInt(emplyeeDetails[4]);
                    employee = new Employee(name, salary, position, dep, age);
                } else {
                    String email = emplyeeDetails[4];
                    employee = new Employee(name, salary, position, dep, email);
                }
            } else {
                employee = new Employee(name, salary, position, dep);
            }

            departments.putIfAbsent(dep, new Department(dep));
            departments.get(dep).addEmployee(employee);

        }
        Map.Entry<String,Department> highestPaid= departments.entrySet().stream().sorted((d1,d2) -> Double.compare(d2.getValue().getSalaryAverage(),d1.getValue().getSalaryAverage())).findFirst().orElse(null);
        System.out.println("Highest Average Salary: "+highestPaid.getKey());
        highestPaid.getValue().getEmployees().stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(),o1.getSalary());
            }
        }).forEach(x -> {
            System.out.printf("%s %.2f %s %d%n",x.getName(),x.getSalary(),x.getEmail(),x.getAge());
        });
    }
}