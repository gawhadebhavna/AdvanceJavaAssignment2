package dao;

import Service.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/delete")
public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("email") != null){
            int partyId = (int) session.getAttribute("partyId");
            System.out.println(partyId);
            try {
                Connection connection = DataBaseConnection.getConnection();
                String forstop = "SET FOREIGN_KEY_CHECKS = 0";
                Statement statement1 = connection.createStatement();
                statement1.executeUpdate(forstop);
                String query = "DELETE user,p " +
                               "FROM UserLoginId user " +
                               "INNER JOIN Party p " +
                               "ON user.partyId=p.partyId " +
                               "WHERE user.partyId="+partyId;

                Statement statement = connection.createStatement();
                statement.executeUpdate(query);

                String forstart = "SET FOREIGN_KEY_CHECKS = 1";
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate(forstart);
                session.invalidate();

                req.setAttribute("deleteMsg", "Profile Deleted Successfully");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("registraion.jsp");
                requestDispatcher.include(req, resp);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else
            resp.sendRedirect("/index.jsp");
    }
}
