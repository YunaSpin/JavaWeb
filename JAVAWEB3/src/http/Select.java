package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show")
public class Select extends HttpServlet{

/*    public class Student{
        int row;
        String name;
        String  number;
        int age;
        Date brith;
        String gende;


        public int getRow(){
            return row;
        }
        public String getName(){
            return name;
        }
        public String getNumber() { return number; }
        public int getAge() {return age;}
        public Date getBrith() {return brith;}
        public String getGende() {return gende;}
    }*/
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getdata(req, resp);
    }
    public void getdata(HttpServletRequest req, HttpServletResponse resp){
        List<Student> students = new ArrayList<>();
        int rowCount = 0;
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
        String SQL = "SELECT * FROM student ";
        if (con == null) return;
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(SQL);
            while (rs.next()) {
//                System.out.println(rs.getString("id"));
                Student student = new Student();
                rowCount++;
                Integer in = rs.getInt(1);
                student.row = in;
                String name = rs.getString(2);
                student.name = name;
                String number = rs.getString(3);
                student.number = number;
                int age = rs.getInt(4);
                student.age = age;
                Date birthday = rs.getDate(5);
                student.brith = birthday;
                String gende = rs.getString(6);//enum类型用String取
                student.gende = gende;
                System.out.println(in + "  "+ name + "  " + number + "  " + age + "  " + birthday + "   " + gende);
                students.add(student);
            }
            con.close();
            req.setAttribute("students", students);
//            String rowcount = String.valueOf(rowCount);
            req.setAttribute("rowcount", rowCount);

            try {
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            System.out.println(rowCount);
        } catch (SQLException e2){}
//        System.out.println("jfakljgalks");
    }

}
