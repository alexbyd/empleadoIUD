package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/employe_iud";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        String Driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(Driver);
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
