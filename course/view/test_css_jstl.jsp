<%--
  Created by IntelliJ IDEA.
  User: Khaitong Lim, 9/28/2022 - 11:58 AM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test CSS and JSTL</title>
    <style>
        .box {
            border: lightgray 1px inset;
            background-color: aliceblue;
            text-align: right;
            border-radius: 4px;
            width: 35px;
            height: 20px;
            margin: 4px;
            display: inline-block;
            padding: 2px 8px 2px 2px;
        }
    </style>
</head>
</head>
<body>

<div style="padding: 10px;display: block;width: 50%;margin: auto">
    <c:forEach begin="1" end="100" var="value">
        <div class="box">${value}</div>
    </c:forEach>
</div>
</body>
</html>
