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
  <link rel="stylesheet" href="styleLogins.css">
</head>
<body>
<div class="wrapper">
  <div class="logo">
    <img src="profile.jpg" alt="">
  </div>
  <div class="text-center mt-4 name">
    Sign in
  </div>
  <form class="p-3 mt-3" action="signin.u" method="post">
    <div class="form-field d-flex align-items-center">
      <span class="far fa-user"></span>
      <input type="text" name="email" id="email" placeholder="Username">
    </div>
    <div class="form-field d-flex align-items-center">
      <span class="fas fa-key"></span>
      <input type="password" name="password" id="pwd" placeholder="Password">
    </div>
    <button class="btn mt-3">Login</button>
  </form>
  <div class="text-center fs-6">
    <a href="#">Forget password?</a> or <a href="singUp.jsp">Sign up</a>
  </div>
</div>
<%--  <h2>Sign In</h2>--%>
<%--  <form action="signin.u" method="post" >--%>
<%--    <label for="email">Email:</label>--%>
<%--    <input type="text" id="email" name="email" required><br>--%>

<%--    <label for="password">Password:</label>--%>
<%--    <input type="password" id="password" name="password" required><br>--%>

<%--    <input type="submit" value="Sign In">--%>
<%--  </form>--%>
<%--  <a href="singUp.jsp">Sing Up</a>    </body>--%>
</body>
</html>
