<%--
  Created by IntelliJ IDEA.
  User: ERRAY
  Date: 22/10/2023
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
      test
    </title>
</head>
<body>
<h1>
  <%
    if (session.getAttribute("user")==null)
    {
      out.println("la");
    }else {
      out.println(session.getAttribute("user"));
    }
  %>
</h1>
</body>
</html>
