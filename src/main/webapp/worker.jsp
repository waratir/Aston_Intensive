<%@ page import="com.example.homework3.models.Worker" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhand
  Date: 26.08.2024
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Workers</h1>
<table>
    <colgroup>
        <col span="2" style="background:Khaki">
        <col style="background-color:#ff564f">
        <col style="background-color:#33d1ff">
        <col style="background-color:#2cff23">
        <col style="background-color:#d94cff">
    </colgroup>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Worker> workers = (List<Worker>) request.getAttribute("workers");
        for (Worker worker : workers) {
    %>
    <tr>
        <td><%= worker.getId() %>
        </td>
        <td><%= worker.getName() %>
        </td>
        <td><%= worker.getPhone() %>
        </td>
        <td><%= worker.getEmail() %>
        </td>
    </tr>
    <%
        }

    %>
    </tbody>
</table>
</body>
</html>
