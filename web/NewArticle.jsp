<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2018
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="net.ukr.kondrashev.User" %>
<%
    User user = (User) (request.getSession().getAttribute("user"));
    String surname = user.getSurname();
%>
<html>
<head>
    <title>NewArticle</title>
</head>
<body>
<form action="/control?do=savenew" method="post">
    <input type="hidden" name="name" value="<%=surname%>">
    <input type="text" name="title" required placeholder="Title"><br>
    <textarea cols="50" rows="15" type="text" name="article" required placeholder="Your article"></textarea><br>
    <input type="submit" value="Save article">
</form>
</body>
</html>
