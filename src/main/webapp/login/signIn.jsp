<%--
  Created by IntelliJ IDEA.
  User: ERRAY
  Date: 20/10/2023
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Sign In</h2>
  <form action="signin.u" method="post" >
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <input type="submit" value="Sign In">
  </form>
  <a href="singUp.jsp">Sing Up</a>    </body>
</body>
</html>
