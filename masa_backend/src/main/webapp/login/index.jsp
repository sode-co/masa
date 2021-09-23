<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.devlogs.masa_backend.common.Masa"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>logi2n3</h1>
<c:set var="redirectUrl" value="http://localhost:${pageContext.request.serverPort}/masa/logingoogle"/>

<form id="googlelogin" method="post" action="https://accounts.google.com/o/oauth2/auth?" >
    <div>
        <input type="hidden" name="response_type" value="code" />
        <input type="hidden" name="client_id" value="${Masa.CLIENT_ID}" />
        <input type="hidden" name="redirect_uri" value="${redirectUrl}" />
        <input type="hidden" name="scope" value="email profile" />
        <input type="hidden" name="access_type" value="offline" />
        <input type="hidden" name="prompt" value="consent"/>
        <input type="submit" value="go" />
    </div>
</form>
<h1>login</h1>
</body>
</html>
