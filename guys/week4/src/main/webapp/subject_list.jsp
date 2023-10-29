<%@ page import="java.util.List" %>
<%@ page import="sit.int202.simple.entities.Subject" %>
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
    <%
        List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
        for (Subject subject : subjects) {
    %>
    <tr>
        <td>
            <%= subject.getId() %>
        </td>
        <td>
            <%= subject.getTitle() %>
        </td>
        <td>
            <%= subject.getCredit() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>