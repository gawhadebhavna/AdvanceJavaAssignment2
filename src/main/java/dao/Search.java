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
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int partyId = Integer.parseInt(req.getParameter("partyId"));
        System.out.println(firstName);
        ArrayList al = null;

        try {
            Connection connection = DataBaseConnection.getConnection();
            String searchName = "select firstName, lastName ,partyId from Party";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchName);

            ArrayList searchResult = new ArrayList();

            // Checking if name entered by the user matches inside the database.
            while (resultSet.next()){
                if(resultSet.getString("firstName").equalsIgnoreCase(firstName)
                        && resultSet.getString("lastName").equalsIgnoreCase(lastName)
                        && resultSet.getString("partyId").equalsIgnoreCase(String.valueOf(partyId))){

                    // Fetches profile from DB based on user input
                    String profileQuery = "SELECT * FROM Party p INNER JOIN UserLoginId u " +
                            "ON p.partyId = u.partyId WHERE firstName ='"+firstName+"'" +
                            "AND lastName ='"+lastName+"' And p.partyId ='"+partyId+"'";
                    Statement statement1 = connection.createStatement();
                    System.out.println("Profile Query Executed");
                    ResultSet result = statement1.executeQuery(profileQuery);

                    if(result.next()){
                        String email= result.getString("userLoginId");
                        String city = result.getString("city");
                        String zip = result.getString("zip");
                        String state = result.getString("state");
                        String country = result.getString("country");
                        String phone = result.getString("phone");

                        HttpSession httpSession = req.getSession();
                        httpSession.setAttribute("partyId", partyId);
                        httpSession.setAttribute("firstName", firstName);
                        httpSession.setAttribute("lastName", lastName);
                        httpSession.setAttribute("city", city);
                        httpSession.setAttribute("zip", zip);
                        httpSession.setAttribute("state", state);
                        httpSession.setAttribute("country", country);
                        httpSession.setAttribute("phone", phone);

                        System.out.println(firstName);

                        al  = new ArrayList();

                        al.add(result.getString(1));
                        al.add(result.getString(2));
                        al.add(result.getString(3));
                        al.add(result.getString(4));
                        al.add(result.getString(5));
                        al.add(result.getString(6));
                        al.add(result.getString(7));
                        al.add(result.getString(8));
                        al.add(result.getString(9));
                        searchResult.add(al);

                    }

                    req.setAttribute("searchResult", searchResult);
                    req.getRequestDispatcher("result.jsp").forward(req, resp);


                } // If condition closed
            } // While Loop Closed
            PrintWriter out = resp.getWriter();
            out.println("No records found");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile.jsp");
            requestDispatcher.forward(req, resp);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}