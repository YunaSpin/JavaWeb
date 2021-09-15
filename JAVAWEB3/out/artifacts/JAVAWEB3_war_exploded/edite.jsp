<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: gether laz
  Date: 2021/9/1
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑基友信息</title>
    <link rel="stylesheet" type="text/css" href="editeCSS.css">
</head>
<body bgcolor="#deb887" onload="setSelect()">
<div align="center">
    <form action="updatesql">
        <%
           int indexid = (int) request.getAttribute("indexid");
           String name = request.getParameter("name");
           String number = request.getParameter("number");
           int age = (int) request.getAttribute("age");
           Date brith = (Date) request.getAttribute("brith");
           String genderv = (String) request.getAttribute("gender");
        %>
        <input type="hidden" name="indexid" value ="${indexid}">
        <font size="8">姓名:</font><input type="text" name="name" value ="${name}"><br><br>
        <font size="8">学号:</font><input type="text" name="number" value="${number}"><br><br>
        <font size="8">年龄:</font><input type="text" name="age" value="${age}"><br><br>
        <font size="8">生日:</font><input type="date" name="bir" value="${brith}"><br><br>
        <font size="8">性别:<select id="gender" name="gende">
            <option  value="男">男</option>
            <option  value="女">女</option>
            <script type="text/javascript">
                function setSelect(){
                    var g = '<%=genderv%>';
                    console.log(g);
                    var opreatesel = document.getElementById("gender");
                    var ops =opreatesel.options;
                    if (ops[0].value == g){
                        ops[0].selected = true;
                    }else {
                        ops[1].selected = true;
                    }
                }
            </script>
        </select><br>
            <input type="submit" value="提交">
            <%--            <button id="butsummit"><font size="4px">提交</font></button>--%>
    </form>
</div>
</body>
</html>
