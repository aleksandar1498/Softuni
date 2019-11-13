package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author astefanov2
 *
 */
public class ConnectionDatabase {
    private ConnectionDatabase() {
        // Utility Class
    }

    @SuppressWarnings("nls")
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    @SuppressWarnings("nls")
    private static final String SERVER = "localhost";
    @SuppressWarnings("nls")

    private static final String DBPORT = "1521";
    @SuppressWarnings("nls")
    private static final String DBNAME = "orcl";
    @SuppressWarnings("nls")
    // this is the sid -> previous was intern
    private static final String DBUSER = "C##alex";

    @SuppressWarnings("nls")
    private static final String DBPASS = "alex";
    /*
     * @SuppressWarnings("nls") private static final String DBUSER = "astefanov2";
     *
     * @SuppressWarnings("nls") private static final String DBPASS = "astefanov2";
     */

//https://localhost:5500/em
    /**
     * Attempts to establish a connection to the given database URL
     *
     * @return the established connection to the database
     * @throws ClassNotFoundException if the JDBC driver is not found
     * @throws SQLException           if the connection fails
     */
    @SuppressWarnings({ "javadoc", "nls" })
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (final ClassNotFoundException exc) {
            System.err.println(exc.getMessage());
            System.exit(-1);
        }

        return DriverManager.getConnection("jdbc:oracle:thin:@" + SERVER + ":" + DBPORT + ":" + DBNAME, DBUSER, DBPASS);
    }
}
