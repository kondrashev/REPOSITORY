<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2018
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="net.ukr.kondrashev.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%List articles = (ArrayList) request.getAttribute("articles");%>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<table>
    <tr>
        <th>№</th>
        <th>Title</th>
        <th>Author</th>
        <th>Date</th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (int i = 0; i < articles.size(); i++) {
            Article article = (Article) articles.get(i);
            if (i != 0) {
    %>
    <tr>
        <td><%=i%>
        </td>
        <td><%=article.getSurname()%>
        </td>
        <td><%=article.getAuthor()%>
        </td>
        <td><%=new Date(article.getDate()).toString()%>
        </td>
        <td>
            <form action="/control?do=edit&did=read" method="post">
                <input type="hidden" name="date" value="<%=article.getDate()%>">
                <input type="submit" value="Edit article">
                <input type="submit" value="Read article">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
