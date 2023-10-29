<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 10/2/2023
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User registered</title>
</head>
<body>
<c:if test="${message != null}">
    ${message} <br><br>
    <a href="/course-list">
        <button>OK</button>
    </a>
</c:if>
<c:if test="${message == null}">
    <c:forEach items="${courseRegistered.history}" var="entry">
        <h3>${semesters[entry.key]}</h3>
        <c:forEach items="${entry.value}" var="subject" varStatus="vs">
            ${vs.count} ${subject.subjectId} ${subject.title} ${subject.credit} <br>
        </c:forEach>
    </c:forEach>
    <a href="index.jsp">
        <button>OK</button>
    </a>
</c:if>
</body>
</html>
