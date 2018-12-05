<%--
  Created by IntelliJ IDEA.
  User: PAVEL
  Date: 01.12.2018
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/user?newuser=no" method="POST">
    <table>
        <tr>
            <td align="right">Login:</td>
            <td align="left"><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td align="right">Password:</td>
            <td align="left"><input type="text" name="password"/></td>
        </tr>
    </table>
    <input type="submit" value="Check">
    <input type="submit" value="Registration">
</form>
</body>
</html>
