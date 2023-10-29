<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registered Courses</title>
</head>
<body>
<c:choose>
    <c:when test="${error != null}">
        <h3>${error}</h3>
    </c:when>
    <c:otherwise>
        <c:forEach items="${courseRegistered.history}" var="entry">
            <h3>${semesters[entry.key]}</h3>
            <hr/>
            <ul>
                <c:forEach items="${entry.value}" var="subject">
                    <li>${subject.subjectId} | ${subject.title}
                        | ${subject.credit}</li>
                </c:forEach>
            </ul>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
