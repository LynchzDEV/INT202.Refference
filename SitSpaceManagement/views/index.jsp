<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>GAY</title>
        <link rel="icon" type="image/x-icon"
              href="https://www.sit.kmutt.ac.th/wp-content/uploads/2016/12/logo-kmutt.png">
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .headerContainer h1 {
            text-align: center;
            margin-top: 50px;
        }

        .desContainer {
            text-align: center;
            margin: 20px;
        }

        .actionContainer {
            display: flex;
            justify-content: space-between;
            margin: 0 auto;
            max-width: 700px;
        }

        .shitContainer {
            flex: 1;
            padding: 20px;
        }

        .input label {
            display: block;
            margin-bottom: 10px;
        }

        .input input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: black;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            width: 108%;
        }

        h3 {
            margin-top: 20px;
            text-align: center;
        }
    </style>
    <body>
        <div class="headerContainer">
            <h1>Sit Space Management</h1>
        </div>
        <div class="desContainer">
            Page:&nbsp;
            <a href="index.jsp">ADD/REMOVE Student</a>
            &nbsp;|&nbsp;
            <a href="listAllStudent.jsp">ALL DATA</a>
        </div>
        <div class="actionContainer">
            <!-- Add Student Container -->
            <div class="shitContainer">
                <div class="topic">
                    <h3>Add Student Data: </h3>
                </div>
                <div class="input">
                    <form action="AddServlet" method="post">
                        <label for="IDa">ID:</label>
                        <input type="number" id="IDa" name="IDa" required>
                        <label for="Name">Name:</label>
                        <input type="text" id="Name" name="Name" required>
                        <label for="Score">Score:</label>
                        <input type="number" id="Score" name="Score" required>
                        <input type="submit" value="ADD">
                    </form>
                </div>
            </div>
            <!-- Remove Student Container -->
            <div class="shitContainer">
                <div class="topic">
                    <h3>Remove:</h3>
                </div>
                <div class="input">
                    <form action="RemoveServlet" method="post">
                        <label for="IDr">ID:</label>
                        <input type="text" id="IDr" name="IDr" required>
                        <input type="submit" value="ADD" required>
                    </form>
                </div>
            </div>
        </div>
        <h3>${Message}</h3>
    </body>
</html>
