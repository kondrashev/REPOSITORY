<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.11.2018
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regisration</title>
</head>
<body>
<form action="/user?newuser=yes" method="post">
    <table>
        <tr>
            <td align="right">Login:</td>
            <td align="left"><input type="text" name="login" required></td>
        </tr>
        <tr>
            <td align="right">Password:</td>
            <td align="left"><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td align="right">Surname:</td>
            <td align="left"><input type="text" name="name" required></td>
        </tr>
    </table>
    <input type="submit" value="Register">
</form>
</body>
</html>
