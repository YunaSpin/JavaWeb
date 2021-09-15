package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/inset")
public class Insert extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rowcount = Integer.parseInt(req.getParameter("rowcount"));
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        int age = Integer.parseInt(req.getParameter("age"));
        Date bir = Date.valueOf(req.getParameter("bir"));
        String gender = req.getParameter("gende");
        System.out.println(rowcount + " " + name + " " + number + " " +age + " " +bir + " " +gender);
        insertdata(rowcount, name, number, age, bir, gender);
        resp.sendRedirect("show");
    }
    public void insertdata(int rowcount, String name, String number, int age, Date bir, String gender){
        Connection con = null;
        Statement sql;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {}
        String uri = "jdbc:mysql://localhost:3306/exampletest14_1?"+
                "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
        String user = "root";
        String password = "root";
        try {
            con= DriverManager.getConnection(uri, user, password);
        } catch (SQLException e) {}
        String addone = "('"+ rowcount +"', '"+ name +"','"+ number +"','"+ age +"','"+ bir +"','"+ gender +"')";
        String SQL = "insert into student values " + addone;
        try {
            sql = con.createStatement();
            int ok = sql.executeUpdate(SQL);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
