<%--
  Created by IntelliJ IDEA.
  User: zilenka
  Date: 29.12.2022
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<h1>Users</h1>
<%@ page import="com.example.jenkinsapplication.entity.User" %>
<%@ page import="java.util.List" %>
<p>
    <%
        for (User user : (List<User>) session.getAttribute("users")) {
            out.println("<p>" + user.toString() + "</p>");
        }
    %>
</p>
<p></p>
<form method="get" action="update-user?id=<%request.getParameter("id");%>">
    <label>Id for update:
        <input type="number" name="id" min="1">
    </label>
    <button type="submit">Submit</button>
</form>
<p></p>
<form method="get" action="delete-user?id=<%request.getParameter("id");%>">
    <label>Id for delete:
        <input type="number" name="id" min="1">
    </label>
    <button type="submit">Submit</button>
</form>
<p></p>
<a href="add-user">Add user</a>
<p></p>
<a href="index.jsp">Go back</a>
</body>
</html>
