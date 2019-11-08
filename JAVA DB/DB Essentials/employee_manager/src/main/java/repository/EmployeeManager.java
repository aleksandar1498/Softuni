/**
 *
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dxc.internship.models.Employee;

/**
 * @author astefanov2
 *
 */
public class EmployeeManager {

    private final static String SQL_SHOW_ALL = "SELECT * FROM EMPLOYEES";
    private final static String SQL_SHOW_BY_DEPARTMENT_ID = "SELECT * FROM EMPLOYEES e WHERE e.department_id = ?";
    private final static String SQL_INSERT_EMPLOYEE = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT,MANAGER_ID, DEPARTMENT_ID) VALUES ( ?, ?, ?, ?, ?,TO_DATE( ? , 'YYYY-MM-DD'), ?, ?, ?, ?, ? )";
    private final static String SQL_DELETE = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
    private final static String SQL_UPDATE = "UPDATE EMPLOYEES SET  FIRST_NAME = ?' ,LAST_NAME = ?, EMAIL = ? , PHONE_NUMBER = ? , HIRE_DATE = TO_DATE( ? , 'YYYY-MM-DD') , JOB_ID = ? , SALARY = ? , COMMISSION_PCT = ? , MANAGER_ID = ? , DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?" ;
   

    public Map<Integer, Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        final Connection con = ConnectionDatabase.getConnection();
        final Map<Integer, Employee> employees = new LinkedHashMap<>();
        try {
            final Statement prep = con.createStatement();
            try {
                final ResultSet rs = prep.executeQuery(SQL_SHOW_ALL);
                try {
                    while (rs.next()) {
                        final int employeeId = rs.getInt("EMPLOYEE_ID");
                        final Employee employee = new Employee(employeeId, rs.getString("FIRST_NAME"),
                                rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"),
                                rs.getDate("hire_date"), rs.getString("job_id"), rs.getDouble("salary"),
                                rs.getDouble("commission_pct"), rs.getInt("manager_id"), rs.getInt("department_id"));
                        employees.put(employeeId, employee);
                    }
                } finally {
                    rs.close();
                }
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }

        return employees;
    }

    public Map<Integer, Employee> getEmployeesByDepartmentID(int departmentId) throws SQLException, ClassNotFoundException {
        final Connection con = ConnectionDatabase.getConnection();
        final Map<Integer, Employee> employees = new LinkedHashMap<>();
        try {
            final PreparedStatement prep = con.prepareStatement(SQL_SHOW_BY_DEPARTMENT_ID);
            try {
                prep.setInt(1, departmentId);
                final ResultSet rs = prep.executeQuery();
                try {
                    while (rs.next()) {
                        final int employeeId = rs.getInt("EMPLOYEE_ID");
                        final Employee employee = new Employee(employeeId, rs.getString("FIRST_NAME"),
                                rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"),
                                rs.getDate("hire_date"), rs.getString("job_id"), rs.getDouble("salary"),
                                rs.getDouble("commission_pct"), rs.getInt("manager_id"), rs.getInt("department_id"));
                        employees.put(employeeId, employee);
                    }
                } finally {
                    rs.close();
                }
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }

        return employees;
    }

    public void insertEmployee(Employee emp) throws SQLException, ClassNotFoundException {
        final Connection con = ConnectionDatabase.getConnection();
        try {
            final PreparedStatement prep = con.prepareStatement(SQL_INSERT_EMPLOYEE);
            try {
                
                prep.setInt(1, emp.getId());
                prep.setString(2, emp.getFirstName());
                prep.setString(3, emp.getLastName());
                prep.setString(4, emp.getEmail());
                prep.setString(5, emp.getPhoneNumber());
                prep.setString(6, emp.getHireDate().toString());
                prep.setString(7, emp.getJobId());
                prep.setDouble(8, emp.getSalary());
                prep.setDouble(9, emp.getCommissionPct());
                prep.setInt(10, emp.getManagerId());
                prep.setInt(11, emp.getDepartmentId());
                int result = prep.executeUpdate();
                System.out.println(result + " rows affected");
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }
    }
    
    public void updateEmployee(int employeeId,Employee updatedEmployee) throws SQLException, ClassNotFoundException{
        final Connection con = ConnectionDatabase.getConnection();
        try {
            final PreparedStatement prep = con.prepareStatement(SQL_UPDATE);
            try {    
                prep.setString(1, updatedEmployee.getFirstName());
                prep.setString(2, updatedEmployee.getLastName());
                prep.setString(3, updatedEmployee.getEmail());
                prep.setString(4, updatedEmployee.getPhoneNumber());
                prep.setString(5, updatedEmployee.getHireDate().toString());
                prep.setString(6, updatedEmployee.getJobId());
                prep.setDouble(7, updatedEmployee.getSalary());
                prep.setDouble(8, updatedEmployee.getCommissionPct());
                prep.setInt(9, updatedEmployee.getManagerId());
                prep.setInt(10, updatedEmployee.getDepartmentId());
                prep.setInt(11, updatedEmployee.getId());
                
                int result = prep.executeUpdate();
                System.out.println(result + " rows affected");
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }
    }
    
    public int deleteEmployeeBy(int id) throws SQLException, ClassNotFoundException {
        final Connection con = ConnectionDatabase.getConnection();
        int result = 0 ;
        try {
            final PreparedStatement prep = con.prepareStatement(SQL_DELETE);
            try {
               prep.setInt(1, id);
               result = prep.executeUpdate();
              
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }
        return result;
    }
    
    
  

}
