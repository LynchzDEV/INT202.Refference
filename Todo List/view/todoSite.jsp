<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ToDoList</title>
    </head>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
    <body>
        <h1>TodoList:</h1>
        <ul>
            <c:forEach var="item" items="${toDoList.todos}">
                <li>
                    Header: ${item.header} <br>
                    Description: ${item.des} <br>
                    Priority: ${item.priority} <br>
                    Status: ${item.status}
                </li>
            </c:forEach>
        </ul>

        <form action="MainServlet" method="post">
            <h1>Todo info:</h1>
            <label for="header">Header: </label>
            <input type="text" id="header" name="header" required>
            <label for="des">Description: </label>
            <input type="text" id="des" name="des" required>
            <label for="priority">Priority: </label>
            <select name="priority" id="priority" required>
                <option value="high">High</option>
                <option value="medium">Medium</option>
                <option value="low">Low</option>
            </select>
            <input type="submit" value="Add Item">
        </form>
        <form action="Reset" method="post">
            <input type="submit" value="Reset">
        </form>

    </body>
</html>
