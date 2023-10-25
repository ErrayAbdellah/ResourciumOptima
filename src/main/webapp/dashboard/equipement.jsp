<%@ page import="com.resourciumoptima.resourcium_optima.models.entities.Equipement" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ERRAY
  Date: 23/10/2023
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="p-4 sm:ml-64">
  <div class="p-4 mt-14">
    <!-- Modal toggle -->
    <button data-modal-target="staticModal" data-modal-toggle="staticModal" class="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
      New Equipment
    </button>
    <h1></h1>
    <div class="container mx-auto px-4 sm:px-6 lg:px-8 py-8">
      <h2 class="text-2xl font-bold mb-4">Example Datatable</h2>
      <table id="example" class="table-auto w-full">
        <thead>
        <tr>
          <th class="px-4 py-2">Name</th>
          <th class="px-4 py-2">Type</th>
          <th class="px-4 py-2">Etat</th>
          <th class="px-4 py-2">Date achat</th>
          <th class="px-4 py-2">Date maintenance</th>
          <th class="px-4 py-2">Reservation</th>
          <th class="px-4 py-2"></th>
        </tr>
        </thead>
        <tbody>

<%--                            <c:forEach items="${equipementList}" var="equipement">--%>
        <%
          List<Equipement> equipements = (List<Equipement>) request.getAttribute("equipementList");
            System.out.println(equipements);
          for (Equipement equipement:equipements) { %>
        <tr>
          <td class="border px-4 py-2"><%=equipement.getName()%></td>
          <td class="border px-4 py-2"><%=equipement.getType()%></td>
          <td class="border px-4 py-2"><%=equipement.getEtat()%></td>
          <td class="border px-4 py-2"><%=equipement.getDateAchat()%></td>
          <td class="border px-4 py-2"><%=equipement.getDateMaintenance()%></td>
          <td class="border px-4 py-2"><%=(equipement.getReservations()!=null)?equipement.getReservations() :"Abdellah Erray"%></td>
          <td class="border px-4 py-2 flex">
            <form action="update-equipement.u" method="get">
              <input type="hidden" name="id_equipement" value="<%=equipement.getId()%>">
              <input type="submit" value="Update" class="text-white bg-gradient-to-r from-teal-400 via-teal-500 to-teal-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-teal-300 dark:focus:ring-teal-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2" />
            </form>
            <form action="delete-equipement.u" method="get">
              <input type="hidden" name="id_equipement" value="<%=equipement.getId()%>">
              <input type="submit" value="Delete" class="text-white bg-red-700 hover:bg-red-800 focus:outline-none focus:ring-4 focus:ring-red-300 font-medium rounded-full text-sm px-5 py-2.5 text-center mr-2 mb-2 dark:bg-red-600 dark:hover-bg-red-700 dark:focus:ring-red-900" />
            </form>
          </td>
        </tr>
        <% }%>
        </tbody>
      </table>
    </div>

  </div>
</div>
</div>

</div>
<!-- modal save task -->
<div id="staticModal" data-modal-backdrop="static" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] max-h-full">
  <div class="relative w-full max-w-2xl max-h-full">
    <!-- Modal content -->
    <div class="relative bg-white rounded-lg shadow">
      <!-- Modal header -->
      <div class="flex items-start justify-between p-4 border-b rounded-t ">
        <h3 class="text-xl font-semibold text-gray-900 ">
          Static modal
        </h3>
        <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ml-auto inline-flex justify-center items-center " data-modal-hide="staticModal">
          <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
          </svg>
          <span class="sr-only">Close modal</span>
        </button>
      </div>
      <!-- Modal body -->
      <form class="" action="save.e" method="post">
        <div class=" m-4">

<%--          <div class="mb-6">--%>
<%--            <label for="large-input" class="block mb-2 text-sm font-medium text-gray-900 ">Description</label>--%>
<%--            <input type="text" name="description" id="large-input" class="block w-full p-4 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-md focus:ring-blue-500 focus:border-blue-500">--%>
<%--          </div>--%>
          <div class="mb-6">
            <label for="name-input" class="block mb-2 text-sm font-medium text-gray-900 ">Name</label>
            <input type="text" id="name-input" name="name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
          </div>
          <div class="mb-6">
            <label for="type-input" class="block mb-2 text-sm font-medium text-gray-900 ">Type</label>
            <input type="text" id="type-input" name="type" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
          </div>
          <label for="default" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Default select</label>
          <select id="default" name="etat" class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
            <option selected>Choose a country</option>
            <option value="CA">Canada</option>
            <option value="FR">France</option>
            <option value="DE">Germany</option>
          </select>
          <div class="relative max-w-sm mb-6">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
              <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
              </svg>
            </div>
            <input datepicker datepicker-buttons name="date_achat" type="text" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5 " placeholder="Select date achat ">
          </div>
          <div class="relative max-w-sm mb-6">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
              <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
              </svg>
            </div>
            <input datepicker datepicker-buttons name="date_maintenance" type="text" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5 " placeholder="Select date maintenance ">
          </div>
        </div>

        <!-- Modal footer -->
        <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b ">
            <input type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center" value="Submit"/>
          <button data-modal-hide="staticModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Decline</button>
        </div>
      </form>

    </div>
  </div>
</div>
</div>
</div>
</div>
</div>
<jsp:include page="sidbar.jsp"/>



<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>

<script>
  $(document).ready(function() {
    $('#example').DataTable({});
  });
</script>
</body>
</html>
