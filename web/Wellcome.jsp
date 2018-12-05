<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2018
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="net.ukr.kondrashev.User" %>

<html>
<head>
    <title>Wellcome</title>
</head>
<body>
<%
    User user = (User) (request.getSession().getAttribute("user"));
    String name = user.getSurname();
    String role = user.getRole();
%>
<h1>Wellcome, <%=name%>!!!</h1>
<form action="/control?do=new" method="post">
    <input type="submit" value="Add article">
</form>
<form action="/control?do=viewlist" method="post">
    <input type="submit" value="Read articles">
</form>
</body>
</html>
