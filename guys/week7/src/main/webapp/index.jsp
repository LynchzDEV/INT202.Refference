<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="myTag" uri="http://sit.int202.myTag" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--    <c:if test="${applicationScope.semessters==null}">--%>
<%--        <c:set var="semesters" scope="application" value="${myTag.getAllSemesters()}"/>--%>
<%--    </c:if>--%>
    <h2>Menu</h2><hr>
    <a href="course-list">ลงทะเบียน</a><br>
    <a href="course-registered-history">ประวัติลงทะเบียน</a><br>
</body>
</html>