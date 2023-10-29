<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 9/18/2023
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MultiplicationTable</title>
</head>
<body>
<form action="multiplicationTable" method="get">
    <lable>Input number</lable>
    <input type="text" name="number">
    <input type="submit">
</form>
<c:if test="${message == null}">
    <table style="background: blanchedalmond border-box; border-left: 3px solid;">
        <th colspan="5">Multiple Table of ${param.number}</th>
        <c:forEach begin="1" end="12" var="n">
            <tr>
                <td>${param.number}</td>
                <td>x</td>
                <td>${n}</td>
                <td>=</td>
                <td>${param.number * n}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${message != null}">
    <h3 style="color:red">Error::</h3>
    <h3>${message}<span style="color:black">(${param.number == null ? "Null" : param.number})</span></h3>
</c:if>

<h3></h3>
</body>
</html>
