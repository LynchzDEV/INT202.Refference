<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Test CSS JSTL</title>
</head>
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
<body>
<div style="padding: 10px; display: block; width: 50%; margin: auto">
    <c:forEach var="value" begin="1" end="100">
        <div class="box">${value}</div>
    </c:forEach>
</div>
</body>
</html>
