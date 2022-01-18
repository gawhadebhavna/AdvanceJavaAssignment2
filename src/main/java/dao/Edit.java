package dao;

import Pojo.Party;
import Service.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/editprofile")
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            Connection connection = DataBaseConnection.getConnection();
            int partyId = (int)session.getAttribute("partyId");

            System.out.println(partyId);
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String country = req.getParameter("country");
            String phone = req.getParameter("phone");

            System.out.println(firstName);

            String updateQuery = "UPDATE Party SET firstName = ?, lastName = ?, city = ?, state = ?, " +
                    "country = ?, phone = ? WHERE partyId =" + partyId;

            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, city);
            statement.setString(4, state);
            statement.setString(5, country);
            statement.setString(6, phone);
            statement.executeUpdate();

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/profile.jsp");
            requestDispatcher.include(req, resp);
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
