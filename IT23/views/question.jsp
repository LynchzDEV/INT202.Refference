<%--
  Created by IntelliJ IDEA.
  User: God_5
  Date: 10/29/2022
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdditionQuiz</title>
    <link rel="stylesheet" href="css/question.css">
</head>
<body>
<h1>Addition Quiz Status : ${countCorrectAnswer}/${countTotal}</h1>
<form action="QuestionServlet" method="post">
    <label>
        What is ${num1} + ${num2} =
        <input type="text" name="userAnswer">
        <input type="submit" value="Submit">
    </label>
</form>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<c:if test="${not empty correctMessage}">
    <h3>${correctMessage}</h3>
</c:if>
<c:if test="${not empty congratsMessage}">
    <h3>${congratsMessage}</h3>
</c:if>
<br>
<br>
<p>Developed by Tanasit Aintakhan</p>
</body>
</html>
