/**
 *
 */
package com.dxc.internship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author astefanov2
 *
 */
public class CarRepository {
    /**
     * @throws ClassNotFoundException
     */
    public CarRepository() throws ClassNotFoundException {
        Class.forName(DRIVER);
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
    @SuppressWarnings("nls")
    private static final String SQL_INSERT = "INSERT INTO car VALUES(?,?,?)";
    @SuppressWarnings("nls")
    private static final String SQL_UPDATE = "UPDATE car SET car_make = ? ,car_model = ? WHERE car_id = ?";
    @SuppressWarnings("nls")
    private static final String SQL_DELETE = "DELETE FROM car WHERE car_id = ?";
    @SuppressWarnings("nls")
    private static final String SQL_SHOW = "SELECT * FROM car";

    /*
     * private static final String DBUSER = "astefanov2"; private static final
     * String DBPASS = "astefanov2";
     */
    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    // CRUD
    @SuppressWarnings("nls")
    private static Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:oracle:thin:@" + SERVER + ":" + DBPORT + ":" + DBNAME, DBUSER, DBPASS);
    }

    /**
     * @param id
     * @param make
     * @param model
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    @SuppressWarnings("resource")
    public static void addCar(int id, String make, String model) throws ClassNotFoundException, SQLException {
        final Connection con = getConnection();
        try {
            final PreparedStatement prep = con.prepareStatement(SQL_INSERT);
            try {
                prep.setInt(1, id);
                prep.setString(2, make);
                prep.setString(3, model);

                final int affectedRows = prep.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Operation successfull , modified " + affectedRows);
                }
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }

    }

    /**
     * @param id
     * @param make
     * @param model
     * @throws SQLException
     */
    @SuppressWarnings({ "resource" })
    public static void updateCar(int id, String make, String model) throws SQLException {
        final Connection con = getConnection();
        try {

            final PreparedStatement prep = con.prepareStatement(SQL_UPDATE);
            try {
                prep.setString(1, make);
                prep.setString(2, model);
                prep.setInt(3, id);

                final int affectedRows = prep.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Update successfull , modified " + affectedRows);
                }
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }
    }

    /**
     * @param id
     * @throws SQLException
     */
    @SuppressWarnings({ "resource", "nls" })
    public static void deleteCar(int id) throws SQLException {
        final Connection con = getConnection();
        try {
            final PreparedStatement prep = con.prepareStatement(SQL_DELETE);
            try {
                prep.setInt(1, id);

                final int affectedRows = prep.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Delete successfull , modified " + affectedRows);
                }
            } finally {
                prep.close();
            }

        } finally {
            con.close();
        }
    }

    /**
     * @throws SQLException
     */
    @SuppressWarnings({ "resource", "nls" })
    public static void showAllCars() throws SQLException {
        final Connection con = getConnection();
        try {
            final Statement st = con.createStatement();
            try {

                final ResultSet res = st.executeQuery("SELECT * FROM car");
                try {
                    while (res.next()) {
                        System.out.print(String.format("Id : %d , Make : %s, Model : %s%n", res.getInt("car_id"),
                                res.getString("car_make"), res.getString("car_model")));
                    }
                } finally {
                    res.close();
                }

            } finally {
                st.close();
            }

        } finally {
            con.close();
        }
    }

    /**
     * @param filter
     * @param value
     * @throws SQLException
     */
    @SuppressWarnings({ "nls", "resource" })
    public static void showCarsBy(String filter, String value) throws SQLException {
        final Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement(String.format("SELECT * FROM car WHERE %s = ?", filter));

            try {

                st.setString(1, value);

                final ResultSet res = st.executeQuery();
                try {
                    while (res.next()) {
                        System.out.print(String.format("Id : %d , Make : %s, Model : %s%n", res.getInt("car_id"),
                                res.getString("car_make"), res.getString("car_model")));
                    }
                } finally {
                    res.close();
                }

            } finally {
                st.close();
            }

        } finally {
            con.close();
        }
    }

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @SuppressWarnings({ "nls", "static-access" })
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final CarRepository repo = new CarRepository();
        repo.showCarsBy("CAR_MODEL", "320");
    }

    /*
     * Add Car repo.addCar(1, "BMW", "320"); repo.addCar(2, "Audi", "A3");
     * repo.addCar(3,"VW", "Golf");
     */

}
