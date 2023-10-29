<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Multiplication Table</title>
</head>
<body>
<c:choose>
    <c:when test="${error != null}">
        <h1>${error}</h1>
    </c:when>
    <c:otherwise>
        <table>
            <caption>Table of multiplication of ${number}</caption>
            <tbody>
            <c:forEach var="i" begin="1" end="12">
                <tr>
                    <td>${number} * ${i} =</td>
                    <td>${number * i}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
