<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add New Todo</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
            integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body>
<c:choose>
    <c:when test="${error != null}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:when>
    <c:when test="${success != null}">
        <div class="alert alert-success" role="alert">
            ${success}
        </div>
    </c:when>
</c:choose>
<div class="container-fluid">
    <h1>Todo List</h1>
    <hr/>
    <form method="post" action="add-todo">
        <label for="title" class="form-label">Title</label>
        <input type="text" name="title" id="title" class="form-control"
               aria-describedby="todoTitle">
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
    <a href="todo-list">Back</a>
</div>
</body>
</html>
