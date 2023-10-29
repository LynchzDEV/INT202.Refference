<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Subject List</title>
</head>
<body>
<table>
    <caption>Subject List</caption>
    <thead>
    <tr>
        <th>Subject Code</th>
        <th>Title</th>
        <th>Credit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${subjects}" var="subject">
        <tr>
            <td>${subject.getId()}</td>
            <td>${subject.getTitle()}</td>
            <td>${subject.getCredit()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>