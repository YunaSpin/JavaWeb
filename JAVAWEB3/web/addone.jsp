<%--
  Created by IntelliJ IDEA.
  User: gether laz
  Date: 2021/9/1
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加基友信息</title>
    <link rel="stylesheet" type="text/css" href="editeCSS.css">
</head>
<body bgcolor="#ffe4c4">
    <div align="center">
        <%
            int rowcount = Integer.parseInt(request.getParameter("rowcount"));
            rowcount += 1;
            System.out.println("ads"+rowcount);
        %>
        <form action="inset">
            <font size="8">人数:</font><input type="text" readonly="readonly" value="<%=rowcount%>" name="rowcount"><br><br>
            <font size="8">姓名:</font><input type="text" name="name"><br><br>
            <font size="8">学号:</font><input type="text" name="number"><br><br>
            <font size="8">年龄:</font><input type="text" name="age"><br><br>
            <font size="8">姓名:</font><input type="date" name="bir"><br><br>
            <font size="8">性别:<select id="gender" name="gende">
                                    <option selected="selected" value="男">男</option>
                                    <option value="女">女</option>
                                 </select><br>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
