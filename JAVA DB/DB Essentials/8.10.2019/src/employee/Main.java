package employee;

import employee.connection.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Please select your command ");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Connection con = DBConnection.getConnection("root", "Alex_1415", "interview");
        while (input[0] != "End"){
            switch (input[0]) {
                case "INSERT":
                    String name = input[1];
                    PreparedStatement statement = con.prepareStatement("INSERT INTO employee(name) VALUES(?)");
                    statement.setString(1,name);
                    statement.executeUpdate();
                    break;
                case "SHOW":
                    Statement state = con.createStatement();
                    ResultSet resultSet = state.executeQuery("SELECT * FROM employee");
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
                    }
                    break;
                case "REMOVE":
                    String nameToRemove = input[1];
                    PreparedStatement removeStatement = con.prepareStatement("DELETE from employee WHERE employee.name=?");
                    removeStatement.setString(1,nameToRemove);
                    removeStatement.executeUpdate();
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }




    }
}
