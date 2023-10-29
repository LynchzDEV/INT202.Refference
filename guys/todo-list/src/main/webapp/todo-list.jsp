<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Todo List</title>
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
<a href="add-todo"
   class="btn btn-primary">Add Todo</a>
<div class="container-fluid">
    <div class="row">
        <div class="col-6">
            <h3>Todo:</h3>
            <hr>
            <c:forEach var="todo" items="${waitingTodos}">
                <div class="card" style="width: 100%;">
                    <div class="card-body">
                        <h5 class="card-title">${todo.title}</h5>
                        <a href="set-todo-status?id=${todo.id}&status=done"
                           class="btn btn-primary">Move To Done</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-6">
            <h3>Done:</h3>
            <hr>
            <c:forEach var="todo" items="${doneTodos}">
                <div class="card" style="width: 100%;">
                    <div class="card-body">
                        <h5 class="card-title">${todo.title}</h5>
                        <span class="badge rounded-pill text-bg-success">Done</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
