package dao;

import Pojo.UserLogin;
import Service.DataBaseConnection;
import javax.servlet.http.HttpServlet;
import java.sql.*;

public class Login extends HttpServlet {

    public static boolean validateLogin(UserLogin login){
        try {
            Connection connection = DataBaseConnection.getConnection();

            String query = "select userLoginId, password from UserLogin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                // Checking if entered email & password are correct.
                if (resultSet.getString("userLoginId").equalsIgnoreCase(login.getEmail())
                        && resultSet.getString("password").equals(login.getPassword())) {




                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}