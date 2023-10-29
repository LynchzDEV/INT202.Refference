<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: koranatruedeecharoen
  Date: 29/10/23
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add/Remove Student</title>
</head>
<style>
  .success {
    background-color: aqua;
    border: 1px solid black;
    padding: 12px 24px;
  }

  .error {
    background-color: red;
    border: 1px solid black;
    padding: 12px 24px;
  }
</style>
<body>
<h1>SIT Space Management</h1>
<p>Pages: <a href="add-remove-student">Add/Remove Student</a> |
    <a href="all-student-data">All Data</a>
</p>
<hr/>
<h3>Add Student Data:</h3>
<form action="add-student" method="post">
    <c:choose>
        <c:when test="${error != null}">
            <div class="error">${error}</div>
        </c:when>
        <c:when test="${success != null}">
            <div class="success">${success}</div>
        </c:when>
    </c:choose>
    <div>
        <label for="id">ID </label><input type="number" name="id" id="id">
    </div>
    <div>
        <label for="name">Name </label><input type="text" name="name" id="name">
    </div>
    <div>
        <label for="score">Score </label><input type="number" name="score"
                                               id="score">
    </div>
    <input type="submit" value="Submit">
</form>
<hr/>
<h3>Remove Student Data:</h3>
<form action="remove-student" method="post">
    <div>
        <label for="remove-id">ID </label><input type="number" name="id"
                                                 id="remove-id">
    </div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
