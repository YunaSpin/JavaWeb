package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/delet")
public class Delete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int indexid = Integer.parseInt(req.getParameter("index"));
        deletsql(indexid);
        System.out.println("adfa" + indexid);
        resp.sendRedirect("show");
    }
    public void deletsql(int indexid){
        Connection con = null;
        Statement sql, sql1, sql3;
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
        String SQL = "delete from student where id = '"+ indexid +"'";
        String SQL2 = "SELECT * FROM student ";

        try {
            int oldid, newid;

            sql = con.createStatement();
            sql1 = con.createStatement();
            sql3 = con.createStatement();

            int ok = sql.executeUpdate(SQL);
            rs = sql1.executeQuery(SQL2);
//            rs.absolute(indexid-1);
            while (rs.next()){
                oldid = rs.getInt(1);
                System.out.println("老id"+oldid);
                if ((oldid == indexid + 1) || (oldid > indexid + 1)){
                    newid = oldid - 1;
                    sql3.executeUpdate("update student set id = '"+ newid +"' where id = '"+ oldid +"'");
                }

            }
            con.close();
            rs.close();
            sql.close();
            sql1.close();
            sql3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
