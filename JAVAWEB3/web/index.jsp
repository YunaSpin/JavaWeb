<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%--
  Created by IntelliJ IDEA.
  User: gether laz
  Date: 2021/8/29
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>好基友管理名单</title>
    <link rel="stylesheet" type="text/css" href="tabCSS.css">
      <script src="tabjs.js"></script>
  <body bgcolor="#ffe4c4">
  <div align="center">
    <table border="2" width="600" id="tab">
      <tr id="bt">
        <th>name</th>
        <th>number</th>
        <th>age</th>
        <th>birthday</th>
        <th>gender</th>
        <th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
      </tr>
      <jsp:useBean id="students" scope="request" type="java.util.List"/>
        <%
            int i = 1;
            int row = (int) request.getAttribute("rowcount");
            System.out.println(row);
        %>
      <c:forEach items = "${students}" var = "student">
          <%
              int now = i;
          %>
          <tr>
              <td align="center">
                  <input type="text" readonly="readonly"  value="${student.name}">
              </td>
              <td align="center">
                  <input type="text" readonly="readonly" value="${student.number}">
              </td>
              <td align="center">
                  <input type="text" readonly="readonly" value="${student.age}">
              </td>
              <td align="center">
                  <input type="date" readonly="readonly" value="${student.brith}">
              </td>
              <td align="center">
                  <input type="text" readonly="readonly" value="${student.gende}">
              </td>
              <td id="tdedidel" align="center" nowrap="nowrap">
                  <button onclick="update('<%=now%>')">编辑</button>
                  <button onclick="confirmdelet('<%=now%>')">删除</button>
              </td>
          </tr>
          <%
              i++;
          %>
      </c:forEach>
    </table>
    <button><a href="addone.jsp?rowcount=<%=row%>">添加一行</a></button>
  </div>
  </body>
</html>