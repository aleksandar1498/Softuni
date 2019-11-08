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
        //Utility Class
    }
    @SuppressWarnings("nls")
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    @SuppressWarnings("nls")
    private static final String SERVER = "10.82.63.110";
    @SuppressWarnings("nls")
    private static final String DBPORT = "1521";
    @SuppressWarnings("nls")
    private static final String DBNAME = "intern";
    @SuppressWarnings("nls")
    private static final String DBUSER = "astefanov2";
    @SuppressWarnings("nls")
    private static final String DBPASS = "astefanov2";
    
    /**
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
      //  Class.forName(DRIVER);
        return DriverManager.getConnection("jdbc:oracle:thin:@" + SERVER + ":" + DBPORT + ":" + DBNAME, DBUSER, DBPASS);
    }
}
