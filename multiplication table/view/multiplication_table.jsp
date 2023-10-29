<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Multiplication Table</title>
        <%--        <link rel="stylesheet" type="text/css" href="./WEB-INF/style.css">--%>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }

            h2 {
                text-align: center;
                margin-top: 20px;
            }

            form {
                text-align: center;
                margin-top: 20px;
            }

            label {
                font-weight: bold;
            }

            input[type="text"] {
                padding: 5px;
                font-size: 16px;
            }

            input[type="submit"] {
                padding: 5px 10px;
                background-color: #007BFF;
                color: #fff;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            h3 {
                text-align: center;
                margin-top: 20px;
            }

            table {
                margin: 0 auto;
                border-collapse: collapse;
                width: 80%;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            th {
                background-color: #007BFF;
                color: #fff;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            .container {
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                gap: 10px;
            }
        </style>
    </head>
    <body>
        <h2>Multiplication Table Generator</h2>

        <form action="${pageContext.request.contextPath}/multiplication_table" method="POST">
            Enter a number: <label for="number"></label><input type="text" name="number" id="number">
            <input type="submit" value="Generate Table">
        </form>

        <c:if test="${not empty requestScope.multiplicationTable}">
            <div class="container">
                <h3>Multiplication Table for </h3>
                <h2 style="color: coral">${requestScope.number}</h2>
            </div>
            <table border="1">
                <tr>
                    <th>Expression</th>
                    <th>Result</th>
                </tr>
                <c:forEach items="${requestScope.multiplicationTable}" var="entry" varStatus="status">
                    <tr>
                        <td>${entry}</td>
                        <td>${requestScope.multiplicationTableResult[status.index]}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
