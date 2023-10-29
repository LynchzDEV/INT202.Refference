<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 9/4/2023
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject list</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div>
    <h3>Subject Listing:</h3>
    <table class="table-auto bg-[#faf7e3]">
        <tr class="">
            <th class="">No.</th>
            <th class="">Subject Id</th>
            <th class="">Subject title</th>
            <th class="">Credit</th>
            <th class="">Enroll</th>
        </tr>
        <c:forEach var="subject" items="${subjects}" varStatus="vs">
            <tr class="hover:bg-indigo-300">
                <td class="">${vs.count}</td>
                <td class="">${subject.id}</td>
                <td class="">${subject.title}</td>
                <td class="">${subject.credit}</td>
                <td><input type="checkbox" value="${subject.id}"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
