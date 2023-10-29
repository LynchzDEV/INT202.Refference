<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Select Your Theme</title>
</head>
<style>
  .white-theme {
    background-color: white;
    color: black;
  }

  .dark-theme {
    background-color: black;
    color: white;
  }
</style>
<body class="${cookie.theme.value}">
<h2>Select Your Theme:</h2>
<form action="set-theme" method="post">
    <span>
        <input type="radio" name="theme" id="white-theme" value="white-theme"
               checked="${cookie.theme.value == "white-theme" ? "checked" : ""}">
        <label for="white-theme">White Theme</label>
    </span>
    <span>
        <input type="radio" name="theme" id="dark-theme" value="dark-theme"
               checked="${cookie.theme.value == "dark-theme" ? "checked" : ""}">
        <label for="dark-theme">Dark Theme</label>
    </span>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
