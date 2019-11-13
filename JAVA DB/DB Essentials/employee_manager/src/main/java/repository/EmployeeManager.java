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
    private final Connection con;

    /**
     * @param con
     * @throws SQLException
     */
    @SuppressWarnings("hiding")
    public EmployeeManager(final Connection con) throws SQLException {
        this.con = con;
    }

    @SuppressWarnings("nls")
    private final static String SQL_SHOW_ALL = "SELECT * FROM EMPLOYEES";
    @SuppressWarnings("nls")
    private final static String SQL_SHOW_BY_DEPARTMENT_ID = "SELECT * FROM EMPLOYEES e WHERE e.department_id = ?";
    @SuppressWarnings("nls")
    private final static String SQL_INSERT_EMPLOYEE = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT,MANAGER_ID, DEPARTMENT_ID) VALUES ( ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ? )";
    @SuppressWarnings("nls")
    private final static String SQL_DELETE = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
    @SuppressWarnings("nls")
    private final static String SQL_UPDATE = "UPDATE EMPLOYEES SET  FIRST_NAME = ? ,LAST_NAME = ?, EMAIL = ? , PHONE_NUMBER = ? , HIRE_DATE = ?   , JOB_ID = ? , SALARY = ? , COMMISSION_PCT = ? , MANAGER_ID = ? , DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";

    /**
     * Query to database for all the employees present. A {@link SQLException sql}
     * may occur , in this case we simply return an empty Map<Integer,Employee>
     *
     * @return a Map<Integer,Employee> with all the employees in the database
     *
     */
    @SuppressWarnings({ "nls", "boxing" })
    public Map<Integer, Employee> getAllEmployees() {
        final Map<Integer, Employee> employees = new LinkedHashMap<>();
        try (final Statement prep = this.con.createStatement(); final ResultSet rs = prep.executeQuery(SQL_SHOW_ALL);) {
            while (rs.next()) {
                final int employeeId = rs.getInt("EMPLOYEE_ID");
                final Employee employee = new Employee(employeeId, rs.getString("FIRST_NAME"),
                        rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"),
                        rs.getDate("hire_date"), rs.getString("job_id"), rs.getDouble("salary"),
                        rs.getDouble("commission_pct"), rs.getInt("manager_id"), rs.getInt("department_id"));
                employees.put(employeeId, employee);
            }
        } catch (final SQLException exc) {
            System.err.println("The operation cannot be performed " + exc.getMessage());

        }
        return employees;

    }

    /**
     * Query to database for all the employees present in a specific department.
     * {@link SQLException} may occur , in this case we simply return an empty
     * Map<Integer,Employee> employees.
     *
     * @param departmentId
     *
     * @return a Map<Integer,Employee> with all the employees part of a specific
     *         department.
     *
     */
    @SuppressWarnings({ "nls", "boxing" })
    public Map<Integer, Employee> getEmployeesByDepartmentID(final int departmentId) {

        final Map<Integer, Employee> employees = new LinkedHashMap<>();

        try (final PreparedStatement prep = this.con.prepareStatement(SQL_SHOW_BY_DEPARTMENT_ID);) {

            prep.setInt(1, departmentId);
            try (final ResultSet rs = prep.executeQuery();) {

                while (rs.next()) {
                    final Integer employeeId = rs.getInt("EMPLOYEE_ID");
                    final Employee employee = new Employee(employeeId, rs.getString("FIRST_NAME"),
                            rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"),
                            rs.getDate("hire_date"), rs.getString("job_id"), rs.getDouble("salary"),
                            rs.getDouble("commission_pct"), rs.getInt("manager_id"), rs.getInt("department_id"));
                    employees.put(employeeId, employee);
                }
            }
        } catch (final SQLException exc) {
            System.err.println("The operation cannot be performed " + exc.getMessage());

        }

        return employees;
    }

    /**
     * Attempt to insert a new Employee to the database
     *
     * @param emp is the employee that needs to be inserted in the database
     * @return returns > 0 if the insertion has been successful , otherwise returns
     *         0
     */
    @SuppressWarnings({ "boxing", "nls" })
    public int insertEmployee(final Employee emp) {
        int success = 0;
        try (final PreparedStatement prep = this.con.prepareStatement(SQL_INSERT_EMPLOYEE);) {

            prep.setInt(1, emp.getId());
            prep.setString(2, emp.getFirstName());
            prep.setString(3, emp.getLastName());
            prep.setString(4, emp.getEmail());
            prep.setString(5, emp.getPhoneNumber());
            prep.setDate(6, emp.getHireDate());
            prep.setString(7, emp.getJobId());
            prep.setFloat(8, (float) emp.getSalary());
            prep.setFloat(9, (float) emp.getCommissionPct());
            prep.setInt(10, emp.getManagerId());
            prep.setInt(11, emp.getDepartmentId());

            success = prep.executeUpdate();
            // System.out.println(result + " rows affected");
        } catch (final SQLException exc) {
            System.err.println("The operation cannot be performed " + exc.getMessage());

        }
        return success;
    }

    /**
     *
     * @param employeeId      id of the employee whose data has to be edit.
     * @param updatedEmployee is the Employee with changes that needs to be applied
     *                        also in the DB
     * @return returns > 0 if the update has been successful , otherwise returns 0
     */
    @SuppressWarnings({ "nls" })
    public int updateEmployee(final int employeeId, final Employee updatedEmployee) {
        int success = 0;
        try (final PreparedStatement prep = this.con.prepareStatement(SQL_UPDATE);) {
//UPDATE EMPLOYEES SET  FIRST_NAME = ?' ,LAST_NAME = ?, EMAIL = ? , PHONE_NUMBER = ? , HIRE_DATE =  ?  , JOB_ID = ? , SALARY = ? , COMMISSION_PCT = ? , MANAGER_ID = ? , DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?
            prep.setString(1, updatedEmployee.getFirstName());
            prep.setString(2, updatedEmployee.getLastName());
            prep.setString(3, updatedEmployee.getEmail());
            prep.setString(4, updatedEmployee.getPhoneNumber());
            prep.setDate(5, updatedEmployee.getHireDate());
            prep.setString(6, updatedEmployee.getJobId());
            prep.setFloat(7, (float) updatedEmployee.getSalary());
            prep.setFloat(8, (float) updatedEmployee.getCommissionPct());
            prep.setInt(9, updatedEmployee.getManagerId());
            prep.setInt(10, updatedEmployee.getDepartmentId());
            prep.setInt(11, employeeId);

            success = prep.executeUpdate();

        } catch (final SQLException exc) {
            System.out.println("ERROR HERE");
            System.err.println("The operation cannot be performed " + exc.getMessage());
            // exc.printStackTrace();
        }
        return success;
    }

    /**
     *
     * @param id of the employee that needs to be deleted
     * @return > 0 if the update has been successful , otherwise returns 0
     */
    @SuppressWarnings({ "nls" })
    public int deleteEmployeeBy(final int id) {

        int result = 0;
        try (final PreparedStatement prep = this.con.prepareStatement(SQL_DELETE);) {
            prep.setInt(1, id);
            result = prep.executeUpdate();
        } catch (final SQLException exc) {
            System.err.println("The operation cannot be performed " + exc.getMessage());
            // exc.printStackTrace();
        }
        return result;
    }

}
