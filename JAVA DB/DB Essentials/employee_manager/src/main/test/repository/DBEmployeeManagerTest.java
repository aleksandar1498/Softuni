/**
 *
 */
package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.dxc.internship.models.Employee;

/**
 * @author astefanov2
 *
 */
class DBEmployeeManagerTest {
    private EmployeeManager empManager;
    private Connection con;

    @BeforeEach
    void setUp() throws SQLException {
        this.con = ConnectionDatabase.getConnection();
        this.con.setAutoCommit(false);
        this.empManager = new EmployeeManager(this.con);

    }

    @Test
    @DisplayName("getAllEmployees() should return the exact count of rows")
    void testGetAllEmployees() throws SQLException {
        try {
            final Map<Integer, Employee> employees = this.empManager.getAllEmployees();
            assertEquals(DBEmployeeManagerTest.getCountOfEmployees(), employees.size());
        } finally {
            this.con.close();
        }

    }

    @ParameterizedTest
    @MethodSource("invalidDepartments")
    void getEmployeesByDepartmentIDShouldReturnAnEmptyMapIfTheDepartmentIdDoesNotExist(final int invalidDepartment)
            throws SQLException {
        try {
            assertEquals(0, this.empManager.getEmployeesByDepartmentID(invalidDepartment).size());
        } finally {
            this.con.close();
        }

    }

    @SuppressWarnings("boxing")
    private static Stream<Arguments> invalidDepartments() throws SQLException {

        final List<Integer> departments = getDistinctDepartments();
        return Stream.of(Arguments.arguments(departments.get(0) - 1),
                Arguments.arguments(departments.get(departments.size() - 1) + 1));
    }

    @ParameterizedTest
    @MethodSource("validDepartments")
    void getEmployeesByDepartmentIDShouldReturnNonEmptyMapIfTheDepartmentIdExists(final int validDepartment) {
        assertTrue(this.empManager.getEmployeesByDepartmentID(validDepartment).size() > 0);
    }

    private static Stream<Integer> validDepartments() throws SQLException {
        final List<Integer> departments = getDistinctDepartments();
        return departments.stream();
    }

    @SuppressWarnings({ "nls", "boxing" })
    @Test
    void insertEmployeeTestShouldReturnMoreThanZeroIfTheUserIsValid() throws SQLException {
        try {
            final Employee toAdd = new Employee(221, "Aleksandar", "Stefanov", "ASTEFANOV", "515.12368",
                    Date.valueOf("1998-12-14"), "IT_DEV", 1000, 0.2, 1, 2);
            assertEquals(1, this.empManager.insertEmployee(toAdd));

        } finally {
            this.con.rollback();
            this.con.close();
        }
    }

    @ParameterizedTest
    @MethodSource("invalidUsers")
    void insertEmployeeTestShouldReturnZeroIfTheUserIsInvalid(final Employee invalid) throws SQLException {
        try {
            assertEquals(0, this.empManager.insertEmployee(invalid));
        } finally {
            this.con.rollback();
            this.con.close();
        }
    }

    @SuppressWarnings({ "nls", "boxing" })
    private static Stream<Employee> invalidUsers() {
        return Stream.of(
                new Employee(221, "Aleksandar", null, "ASTEFANOV", "515.12368", Date.valueOf("1998-12-14"), "IT_DEV",
                        1000, 0.2, 1, 2),
                new Employee(221, "Aleksandar", "ASTEFANOV", null, "515.12368", Date.valueOf("1998-12-14"), "IT_DEV",
                        1000, 0.2, 1, 2),
                new Employee(221, "Aleksandar", "ASTEFANOV", "ASTEFANOV", "515.12368", Date.valueOf("1998-12-14"), null,
                        1000, 0.2, 1, 2),
                new Employee(221, "Aleksandar", "ASTEFANOV", "ASTEFANOV", "515.12368", null, "IT_DEV", 1000, 0.2, 1,
                        2));
    }
    // TEST UPDATE

    @SuppressWarnings({ "nls", "boxing" })
    @ParameterizedTest
    @MethodSource("invalidEmployeeIDs")
    void testUpdateEmployeeShouldReturnZeroIfTheEmployeeIDIsNotValid(final int invalidEmployeeId) throws SQLException {
        try {
            final Employee toUpdate = new Employee(221, "Aleksandar", "Stefanov", "ASTEFANOV", "515.12368",
                    Date.valueOf("1998-12-14"), "IT_DEV", 1000, 0.2, 1, 2);
            assertEquals(0, this.empManager.updateEmployee(invalidEmployeeId, toUpdate));
        } finally {
            this.con.rollback();
            this.con.close();
        }

    }

    @SuppressWarnings({ "boxing", "nls" })
    @ParameterizedTest
    @MethodSource("validEmployeeIDs")
    void testUpdateEmployeeShouldReturnOneIfTheEmployeeIsUpdated(final int validEmployeeId) throws SQLException {
        try {
            final Employee toUpdate = new Employee(validEmployeeId, "Aleksandar", "Stefanov", "ASTEFANOV", "515.12368",
                    Date.valueOf("1998-12-14"), "IT_DEV", 1000, 0.2, 1, 2);
            assertEquals(1, this.empManager.updateEmployee(validEmployeeId, toUpdate));
        } finally {
            this.con.rollback();
            this.con.close();
        }
    }

    @SuppressWarnings("boxing")
    @ParameterizedTest
    @MethodSource("invalidUsers")
    void testUpdateEmployeeShouldReturnZeroIfTheEmployeeDataIsNotValid(final Employee invalidEmployee)
            throws SQLException {
        try {
            final int index = validEmployeeIDs().findFirst().orElse(null);
            assertEquals(0, this.empManager.updateEmployee(index, invalidEmployee));
        } finally {
            this.con.rollback();
            this.con.close();
        }

    }

    // END TEST UPDATE
    @ParameterizedTest
    @MethodSource("invalidEmployeeIDs")
    void testDeleteEmployeeByIdShouldReturnZeroIfTheEmployeeIsNotDeleted(final int invalidEmployeeId)
            throws SQLException {
        try {
            assertEquals(0, this.empManager.deleteEmployeeBy(invalidEmployeeId));
        } finally {
            this.con.rollback();
            this.con.close();
        }

    }

    @ParameterizedTest
    @MethodSource("validEmployeeIDs")
    void testDeleteEmployeeByIdShouldReturnOneIfTheEmployeeIsDeleted(final int validEmployeeId) throws SQLException {
        try {
            assertEquals(1, this.empManager.deleteEmployeeBy(validEmployeeId));
        } finally {
            this.con.rollback();
            this.con.close();
        }
    }

    private static Stream<Integer> validEmployeeIDs() throws SQLException {
        final List<Integer> employeeIds = getDistinctUserIDs();
        return employeeIds.stream();
    }

    @SuppressWarnings("boxing")
    private static Stream<Arguments> invalidEmployeeIDs() throws SQLException {
        final List<Integer> employeeIds = getDistinctUserIDs();
        return Stream.of(Arguments.arguments(employeeIds.get(0) - 1), Arguments.arguments(employeeIds.get(0) - 2));
    }
    // A COMMON METHOD WILL BE IMPLEMENTED

    @SuppressWarnings({ "nls", "boxing" })
    private static List<Integer> getDistinctDepartments() throws SQLException {

        final List<Integer> distinctSorted = new ArrayList<>();
        try (final Connection con = ConnectionDatabase.getConnection();
                final Statement stmt = con.createStatement();
                final ResultSet rs = stmt.executeQuery(
                        "SELECT DISTINCT(department_id) AS dep_id FROM EMPLOYEES WHERE DEPARTMENT_ID IS NOT NULL ORDER BY DEP_ID ASC  FETCH NEXT 2 ROWS ONLY");) {
            while (rs.next()) {
                distinctSorted.add(rs.getInt("dep_id"));
            }
        }

        return distinctSorted;
    }

    @SuppressWarnings({ "nls", "boxing" })
    private static List<Integer> getDistinctUserIDs() throws SQLException {
        final List<Integer> distinctSorted = new ArrayList<>();
        try (final Connection con = ConnectionDatabase.getConnection();
                final Statement stmt = con.createStatement();

                final ResultSet rs = stmt.executeQuery(
                        "SELECT DISTINCT(employee_id) AS emp_id FROM EMPLOYEES ORDER BY emp_id ASC FETCH NEXT 1 ROWS ONLY ");) {
            while (rs.next()) {
                distinctSorted.add(rs.getInt("emp_id"));
            }
        }
        return distinctSorted;
    }

    @SuppressWarnings("nls")
    private static int getCountOfEmployees() throws SQLException {
        try (final Connection con = ConnectionDatabase.getConnection();
                final Statement stmt = con.createStatement();
                final ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS num_employees FROM EMPLOYEES");) {
            if (rs.next()) {
                return rs.getInt("num_employees");
            }
        }
        return 0;
    }

}
