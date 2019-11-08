import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import com.dxc.internship.models.Employee;

import repository.EmployeeManager;

public class Main {
//INSERT INTO "ASTEFANOV2"."EMPLOYEES" (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, DEPARTMENT_ID) VALUES ('215', 'Aleksandar', 'Stefanov', 'ASTEFANOV', '0923123123', TO_DATE('1998-12-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'IT_DEV', '1700', '120')

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EmployeeManager manager = new EmployeeManager();
        // Map<Integer,Employee> employees = manager.getAllEmployees();
        // Map<Integer, Employee> employees = manager.getEmployeesBy(110);
        /*
         * for (var employee : employees.entrySet()) { Employee emp =
         * employee.getValue(); System.out.
         * printf("ID : %s - First Name : %s - HireDate : %s Deparment : %d%n",
         * employee.getKey(),
         * emp.getFirstName(),emp.getHireDate(),emp.getDepartmentId()); }
         */
      //  Employee toAdd = new Employee(221, "Aleksandar", "Stefanov", "ASTEFANOV", "515.123.4568",
              //  Date.valueOf("1998-12-14"), "IT_DEV", 1000, 2.22, 1, 2);
      //  System.out.println(toAdd.getHireDate().toString());
        //manager.insertEmployee(toAdd);
        // '215', 'Aleksandar', 'Stefanov', 'ASTEFANOV', '0923123123',
        // TO_DATE('1998-12-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'IT_DEV', '1700',
        // '120'
        manager.deleteEmployeeBy(215);
    }

}
