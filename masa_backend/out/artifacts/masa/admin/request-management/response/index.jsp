<%--
  Created by IntelliJ IDEA.
  User: dangminhtien
  Date: 23/09/2021
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${param.fullName} want to become a mentor

    <form action="/masa/api/admin/request-management/response">
        <input type="hidden" value="${param.id}" name="id">
        <input type="hidden" value="${param.userId}" name="userId">
        <input type="submit" value="Denied" name="btAnswer">
        <input type="submit" value="Accept" name="btAnswer">
    </form>
</body>
</html>