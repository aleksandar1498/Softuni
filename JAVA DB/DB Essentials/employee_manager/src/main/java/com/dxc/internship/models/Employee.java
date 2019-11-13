/**
 *
 */
package com.dxc.internship.models;

import java.sql.Date;

/**
 * @author astefanov2
 *
 */
public class Employee {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Date hireDate;
    private final String jobId;
    private final double salary;
    private final double commissionPct;
    private final int managerId;
    private final int departmentId;

    /**
     * @param employeeId    is the unique identifier for the user
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param hireDate
     * @param jobId
     * @param salary
     * @param commissionPct
     * @param managerId
     * @param departmentId
     */
    @SuppressWarnings("hiding")
    public Employee(final Integer employeeId, final String firstName, final String lastName, final String email,
            final String phoneNumber, final Date hireDate, final String jobId, final double salary,
            final double commissionPct, final int managerId, final int departmentId) {
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

    /**
     * @return the id of the employee
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the firstName of the employee
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @return the lastName of the employee
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @return the email of the employee
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the phoneNumber of the employee
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @return the hireDate of the employee
     */
    public Date getHireDate() {
        return this.hireDate;
    }

    /**
     * @return the jobId of the employee
     */
    public String getJobId() {
        return this.jobId;
    }

    /**
     * @return the salary of the employee
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * @return the commissionPct of the employee
     */
    public double getCommissionPct() {
        return this.commissionPct;
    }

    /**
     * @return the managerId of the employee
     */
    public int getManagerId() {
        return this.managerId;
    }

    /**
     * @return the departmentId of the employee
     */
    public int getDepartmentId() {
        return this.departmentId;
    }

    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "Employee [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email="
                + this.email + ", phoneNumber=" + this.phoneNumber + ", hireDate=" + this.hireDate + ", jobId="
                + this.jobId + ", salary=" + this.salary + ", commissionPct=" + this.commissionPct + ", managerId="
                + this.managerId + ", departmentId=" + this.departmentId + "]";
    }

}
