package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet("/signUP")
public class toSignUp extends HttpServlet {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "reallyStrongPwd123";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("html/signUP.html").forward(request,response);
   }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("first_name");
       System.out.println(firstName);
   }
}

