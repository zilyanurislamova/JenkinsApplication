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
<%@ page import="com.example.jenkinsapplication.model.User" %>
<%@ page import="java.util.List" %>
<p>
    <%
        for (User user : (List<User>) session.getAttribute("users")) {
            out.println("<p>" + user.toString() + "</p>");
        }
    %>
</p>
</body>
</html>
