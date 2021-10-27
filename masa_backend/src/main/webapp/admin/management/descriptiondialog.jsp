<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/27/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.devlogs.masa_backend.common.Masa"%>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

</head>
<p id="description" style="padding: 10px; width: 410px">Description Dialog</p>
<script>
    let url = "${Masa.SERVER_HOST}/api/meeting-management/meeting/"+location.search.slice(location.search.indexOf("?id=")).replace("?id=","");
    $.getJSON(url, function (element) {
        document.getElementById("description").innerHTML = element.description;
    });
    console.log('description dialog', location.search);
</script>
<body>

</body>
</html>
