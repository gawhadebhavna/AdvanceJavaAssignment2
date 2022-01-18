package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATA", "bhavna", "123456");
            System.out.println("Connection Established");
            return connection;
        } catch (SQLException sqlException){
            sqlException.getMessage();
            return null;
        }
    }
}
