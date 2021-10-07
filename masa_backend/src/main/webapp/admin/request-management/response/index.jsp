<%-- Created by IntelliJ IDEA. User: dangminhtien Date: 23/09/2021 Time: 21:50
To change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %> <%@ page
import="com.devlogs.masa_backend.common.Masa"%>
<html>
  <head>
    <link rel="shortcut icon" href="${Masa.ICON_URL}" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <link
      href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="path/to/font-awesome/css/font-awesome.min.css"
    />
    <title>Title</title>
  </head>
  <body>
    ${param.fullName} want to become a mentor
      <a href="/masa/api/admin/request-management/response/${param.id}?answer=accept">Accept</a>
      <a href=/masa/api/admin/request-management/response/${param.id}?answer=denied">Denied</a>
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script
    defer
    src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
    integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
    crossorigin="anonymous"
  ></script>
</html>
