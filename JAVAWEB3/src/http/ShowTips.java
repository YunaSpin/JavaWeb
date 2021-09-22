package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/SS")
public class ShowTips extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        Connection con = null;
        Statement sql;
        ResultSet rs;
        String []name = null;
        String a = "";
        int i = 0;
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
        String SQL = "SELECT * FROM student ";
        if (con == null) return;
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(SQL);
            while (rs.next()){
                a += rs.getString(2) + ",";
//                out.println(a);
//                name[i] = rs.getString(2);
//                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(name[1]);
        out.println(a);

//        out.println("hello word");
        out.flush();
        out.close();
    }
}
