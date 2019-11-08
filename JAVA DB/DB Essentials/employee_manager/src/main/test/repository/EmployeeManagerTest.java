/**
 * 
 */
package repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.dxc.internship.models.Employee;

/**
 * @author astefanov2
 *
 */
class EmployeeManagerTest {
    private EmployeeManager empManager;

    @BeforeEach
    void setUp(){
        empManager = new EmployeeManager();
        
    }

    /**
     * Test method for {@link repository.EmployeeManager#getAllEmployees()}.
     */
    @Test
    void testGetAllEmployees()  throws ClassNotFoundException, SQLException {
        Map<Integer,Employee> employees = empManager.getAllEmployees();
        assertEquals(EmployeeManagerTest.getCountOfEmployees(),employees.size());
       
    }

   
    @ParameterizedTest
    @MethodSource("invalidDepartments")
    void getEmployeesByDepartmentIDShouldReturnAnEmptyMapIfTheDepartmentIdDoesNotExist(int invalidDepartment) throws ClassNotFoundException, SQLException {
        assertEquals(0,empManager.getEmployeesByDepartmentID(invalidDepartment).size());
    }
    
    private static Stream<Arguments> invalidDepartments() throws ClassNotFoundException, SQLException{
        List<Integer> departments = getDistinctDepartments();
        return Stream.of(
                Arguments.arguments(departments.get(0)-1),
                Arguments.arguments(departments.get(departments.size()-1)+1)
                );
    }
    
 
    @ParameterizedTest
    @MethodSource("validDepartments")
    void getEmployeesByDepartmentIDShouldReturnNonEmptyMapIfTheDepartmentIdExists(int validDepartment) throws ClassNotFoundException, SQLException {
        assertTrue(empManager.getEmployeesByDepartmentID(validDepartment).size() > 0);
    }
    
    
    private static Stream<Integer> validDepartments() throws ClassNotFoundException, SQLException{
        List<Integer> departments = getDistinctDepartments();
        return departments.stream();
    }

    /**
     * Test method for
     * {@link repository.EmployeeManager#insertEmployee(com.dxc.internship.models.Employee)}.
     */
    @Test
    void testInsertEmployee() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link repository.EmployeeManager#updateEmployee(int, com.dxc.internship.models.Employee)}.
     */
    @Test
    void testUpdateEmployee() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link repository.EmployeeManager#deleteEmployeeBy(int)}.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    @ParameterizedTest
    @MethodSource("invalidEmployeeIDs")
    void testDeleteEmployeeByIdShouldReturnZeroIfTheEmployeeIsNotDeleted(int invalidEmployeeId) throws ClassNotFoundException, SQLException {
        int result = empManager.deleteEmployeeBy(invalidEmployeeId);
        assertEquals(0,result);
    }
    
    @ParameterizedTest
    @MethodSource("validEmployeeIDs")
    void testDeleteEmployeeByIdShouldReturnOneIfTheEmployeeIsDeleted(int validEmployeeId) throws ClassNotFoundException, SQLException {
        int result = empManager.deleteEmployeeBy(validEmployeeId);
        assertEquals(1,result);
    }
    
    private static Stream<Integer> validEmployeeIDs() throws ClassNotFoundException, SQLException{
        List<Integer> employeeIds = getDistinctUserIDs();
        return employeeIds.stream();
    }
    private static Stream<Arguments> invalidEmployeeIDs() throws ClassNotFoundException, SQLException{
        List<Integer> employeeIds = getDistinctUserIDs();
        return Stream.of(
                Arguments.arguments(employeeIds.get(0)-1),
                Arguments.arguments(employeeIds.get(employeeIds.size()-1)+1)
                );
    }
    
    private static int getCountOfEmployees() throws ClassNotFoundException, SQLException {
        final Connection con = ConnectionDatabase.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS num_employees FROM EMPLOYEES");
        if(rs.next()) {
            return rs.getInt("num_employees");
        }
        return 0;
    }
    
    // A COMMON METHOD WILL BE IMPLEMENTED 
    
    
    private static List<Integer> getDistinctDepartments() throws SQLException, ClassNotFoundException{
        final Connection con = ConnectionDatabase.getConnection();
        Statement stmt = con.createStatement();
        List<Integer> distinctSorted = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT DISTINCT(department_id) AS dep_id FROM EMPLOYEES WHERE DEPARTMENT_ID IS NOT NULL ORDER BY DEP_ID ASC  FETCH NEXT 2 ROWS ONLY");
        while(rs.next()) {
            distinctSorted.add(rs.getInt("dep_id"));
        }
        return distinctSorted;
    }
    
    private static List<Integer> getDistinctUserIDs() throws SQLException, ClassNotFoundException{
        final Connection con = ConnectionDatabase.getConnection();
        Statement stmt = con.createStatement();
        List<Integer> distinctSorted = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT DISTINCT(employee_id) AS emp_id FROM EMPLOYEES ORDER BY emp_id ASC FETCH NEXT 2 ROWS ONLY ");
        while(rs.next()) {
            distinctSorted.add(rs.getInt("emp_id"));
        }
        return distinctSorted;
    }

}
