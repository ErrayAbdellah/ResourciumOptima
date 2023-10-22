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
  <link rel="stylesheet" href="styleLogins.css">
</head>
<body>
  <div class="wrapper">
    <div class="logo">
      <img src="profile.jpg" alt="">
    </div>
    <div class="text-center mt-4 name">
      User
    </div>
    <form class="p-3 mt-3" action="add.u" method="post">
      <div class="form-field d-flex align-items-center">
        <span class="far fa-user"></span>
        <input type="text" name="name" id="userName" placeholder="Name">
      </div>
      <div class="form-field d-flex align-items-center">
        <span class="far fa-user"></span>
        <input type="text" name="lastName" placeholder="lastName">
      </div>
      <div class="form-field d-flex align-items-center">
        <span class="far fa-user"></span>
        <input type="email" name="email" placeholder="Email">
      </div>
      <div class="form-field d-flex align-items-center">
        <span class="far fa-user"></span>
        <input type="password" name="password" placeholder="Password">
      </div>
      <div class="form-field d-flex align-items-center">
        <span class="fas fa-key"></span>
        <input type="password" name="passwordConfirm" id="pwd" placeholder="Confirm Password">
      </div>
      <button class="btn mt-3">Login</button>
    </form>
    <div class="text-center fs-6">
      <a href="#">Forget password?</a> or <a href="signIn.jsp">Sign up</a>
    </div>
  </div>
</body>
</html>
