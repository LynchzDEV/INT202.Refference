<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.kuay.models.Student, com.example.kuay.models.AllStudent, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FAME</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 10px;
            padding: 10px;
        }

        h1 {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            margin: 0;
        }

        p {
            text-align: center;
            font-weight: bold;
            margin-top: 20px;
        }

        table, input, button {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        table {
            width: 100%;
            margin-bottom: 50px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #333333;
            color: #dddddd;
        }

        input[type="text"] {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #555;
        }

    </style>
    <body>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Score</th>
                <th>Grade</th>
            </tr>
            <%
                AllStudent students = (AllStudent) session.getAttribute("students");
                if (students != null) {
                    List<Student> studentList = students.getAllStudents();
                    for (Student s : studentList) {
            %>
            <tr>
                <td><%= s.getId() %>
                </td>
                <td><%= s.getName() %>
                </td>
                <td><%= s.getScore() %>
                </td>
                <td><%= s.getGrade() %>
                </td>
            </tr>
            <% }
            } else {
                // You can display a message here if you wish
            }
            %>
        </table>
    </body>
</html>
