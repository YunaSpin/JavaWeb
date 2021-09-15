package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/update")
public class Selectoneline extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"));
        System.out.println(index);
        getonelinedata(req, resp, index);
    }
    public void getonelinedata(HttpServletRequest req, HttpServletResponse resp, int index){
        Connection con = null;
        Statement sql;
        ResultSet rs = null;
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
        String SQL = "SELECT * FROM student where student.id='"+index+"' ";
        if (con == null) return;
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(SQL);
            rs.next();
            Integer in = rs.getInt(1);
            String name = rs.getString(2);
            String number = rs.getString(3);
            int age = rs.getInt(4);
            Date birthday = rs.getDate(5);
            String gende = rs.getString(6);//enum类型用String取
            System.out.println(in + "  "+ name + "  " + number + "  " + age + "  " + birthday + "   " + gende);
            con.close();
            req.setAttribute("indexid", in);
            req.setAttribute("name", name);
            req.setAttribute("number", number);
            req.setAttribute("age", age);
            req.setAttribute("brith", birthday);
            req.setAttribute("gender", gende);

            try {
                req.getRequestDispatcher("edite.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
