package employee.connection;

import java.sql.DriverManager;

public class Connection {
    public Connection connect(String user,String password,String db) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,user,password);
    }
}
