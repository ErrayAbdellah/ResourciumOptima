<%@ page import="com.resourciumoptima.resourcium_optima.models.entities.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ERRAY
  Date: 22/10/2023
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%
    User user = null;
    if (session.getAttribute("user")==null){
        response.sendRedirect(request.getContextPath()+"/login/signIn.jsp");
    }else

    if (session.getAttribute("user")!=null){
        Object userObj = session.getAttribute("user");
        if (userObj instanceof User) {
            user = (User) userObj;
        }
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
        <form action="update.u" method="POST" class="bg-white border p-4 w-96 border-gray-200 rounded-lg shadow">
            <div class="mb-6">
                <label for="Name-input" class="block mb-2 text-sm font-medium text-gray-900 ">Name</label>
                <input type="text" name="name" id="Name-input" value="<%= (user!=null)?user.getName():""%>" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-64 p-2.5" required>
            </div>
            <div class="mb-6">
                <label for="lastName-input" class="block mb-2 text-sm font-medium text-gray-900 ">Last name</label>
                <input type="text" name="lastName" id="lastName-input" value="<%= (user!=null)?user.getLastName():""%>" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-64 p-2.5" required>
            </div>
            <div class="mb-6">
                <label for="email-input" class="block mb-2 text-sm font-medium text-gray-900 ">Base input</label>
                <input type="email" name="email" id="email-input" value="<%= (user!=null)?user.getEmail():""%>" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-64 p-2.5" required>
            </div>
            <div class="mb-6">
                <input type="submit" value="Update" class="text-white bg-gradient-to-r from-teal-400 via-teal-500 to-teal-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-teal-300 dark:focus:ring-teal-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">
            </div>
        </form>
    </div>
</div>
<jsp:include page="sidbar.jsp"/>

<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>
