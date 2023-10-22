<%--
  Created by IntelliJ IDEA.
  User: ERRAY
  Date: 22/10/2023
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%
    if (session.getAttribute("user")==null){
        response.sendRedirect(request.getContextPath()+"/login/signIn.jsp");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="p-4 sm:ml-64">
    <div class="p-4 mt-14">

    </div>
</div>
<jsp:include page="sidbar.jsp"/>

<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>
