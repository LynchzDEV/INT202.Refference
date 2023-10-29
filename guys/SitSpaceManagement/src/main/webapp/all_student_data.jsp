<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>All Student Data</title>
</head>
<style>
  table {
    width: 50%;
    margin: 0 auto;
  }

  table, tr, th, td {
    border: 1px solid black;
  }

  th, td {
    padding: 8px 4px;
  }
</style>
<body>
<h1>SIT Space Management</h1>
<p>Pages: <a href="add-remove-student">Add/Remove Student</a> |
    <a href="all-student-data">All Data</a>
</p>
<hr/>
<table>
    <caption>All Student Data</caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Score</th>
        <th>Grade</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.score}</td>
            <td>${student.grade}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
