/**
 * 
 */
package com.dxc.internship.models;

import java.sql.Date;
import java.sql.Time;

/**
 * @author astefanov2
 *
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private double salary;
    private double commissionPct;
    private int managerId;
    private int departmentId;

    public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate,
            String jobId, double salary, double commissionPct, int managerId, int departmentId) {
        this.id = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public double getSalary() {
        return salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
                + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
                + "]";
    }

  
    

}
