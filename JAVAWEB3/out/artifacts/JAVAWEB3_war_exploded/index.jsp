<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>好基友管理名单</title>
    <link rel="stylesheet" type="text/css" href="tabCSS.css">
      <script src="tabjs.js"></script>
  <body bgcolor="#ffe4c4">
  <div align="center">
      <input type="text" list="data" autocomplete="off" onfocus="ShowName()">
      <script>

          function ShowName() {
              console.log("执行到了这里");
              var datashow = document.getElementById("data");
              var dataArr = null;
              var i = 0;
              datashow.innerText = "";
              var xmlhttp = new XMLHttpRequest();
              //2.设置请求方式和请求地址
              xmlhttp.open("post", "SS");
              //3.发送请求
              xmlhttp.send();
              //4.监听状态的变化
              xmlhttp.onreadystatechange = function () {
                  console.log(xmlhttp.readyState);
                  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
                      var data = xmlhttp.response;
                      console.log(data)
                      /*dataArr[i] = data;
                      i++;*/
                  }
                  dataArr = data.split(",");
                  console.log(dataArr.length);
                  for (var j = 0; j < dataArr.length-1; j++){
                      // console.log(dataArr[j]+"hah");
                      var opt = document.createElement("option");
                      opt.innerText = dataArr[j];
                      datashow.appendChild(opt);
                  }
              }
          }
      </script>
        <datalist id="data"></datalist>
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