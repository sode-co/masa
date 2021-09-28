<%--
  Created by IntelliJ IDEA.
  User: dangminhtien
  Date: 17/09/2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.devlogs.masa_backend.common.Masa"%>
<html>
<head>
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <title>Mentor Profile</title>
    <style>
        body{
            background-color: black;
        }
    </style>
</head>
<body>
    <h1>Mentor ne</h1>
    <%@ include file="../../shared/meeting/_layout_view_meeting.jsp"%>
    <%@ include file="../../shared/meeting/_layout_create_meeting.jsp"%>
<%--    <%@ include file="../../shared/meeting/_view_all_meeting.jsp"%>--%>
</body>
</html>
