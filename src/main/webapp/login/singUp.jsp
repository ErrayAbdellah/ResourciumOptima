<%--
  Created by IntelliJ IDEA.
  User: ERRAY
  Date: 18/10/2023
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Sign Up</h2>
  <form action="add.u" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="last-name">Last name:</label>
    <input type="text" id="last-name" name="lastName" required><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="confirm_password">Confirm Password:</label>
    <input type="password" id="confirm_password" name="confirm_password" required><br>

    <input type="submit" value="Sign Up">
  </form>
  <a href="signIn.jsp">Sing In</a>
</body>
</html>
