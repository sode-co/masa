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
    ${requestScope.FullName} want to become a mentor

    <form action="/admin/request-management/response">
        <input type="hidden" value="${request.id}" name="id">
        <input type="submit" value="Denied" name="btAnswer">
        <input type="submit" value="Accept" name="btAnswer">
    </form>
</body>
</html>
